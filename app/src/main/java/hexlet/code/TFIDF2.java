package hexlet.code;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TFIDF2 {

    public static double getWordTFIDF(List<Map<String, String>> docs, Map<String, String> doc, String word) {
        double tf = getTF(doc, word);
        double idf = getIDF(docs, word);
        return tf * idf;
    }

    public static double getIDF(List<Map<String, String>> docs, String word) {
        return 1.0;
    }

    public static double getTF(Map<String, String> doc, String word) {
        long numberOfTheCertainWordInDocument = getNumberOfWordsInDocument(doc, word);
        long numberOfWordsInDocument = getNumberOfWordsInDocument(doc);
        return (double) numberOfTheCertainWordInDocument / numberOfWordsInDocument;
    }

    public static long getNumberOfWordsInDocument(Map<String, String> doc) {
        String text = doc.get("text");
        List<String> words = getSplittedText(text);
        return words.size();
    }

    public static long getNumberOfWordsInDocument(Map<String, String> doc, String word) {
        String text = doc.get("text");
        String term = getTermFromToken(word);
        List<String> words = getSplittedText(text);
        return words.stream()
                .filter(x -> x.equals(term))
                .count();

    }

    public static List<String> getSplittedText(String text) {
        return Arrays.stream(text.toLowerCase().split("\\s+"))
                .map(TFIDF2::getTermFromToken)
                .toList();
    }




    public static String getTermFromToken(String token) {
        return Pattern.compile("\\w+")
                .matcher(token)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.joining()).toLowerCase();
    }


}

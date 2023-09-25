package hexlet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TermUtils {
    /**
     * @param word accepts a string as input
     * @return extracts only letters from the string, adds a word terminator at the beginning and end,
     * and returns the term
     */
    public static Pattern getTermFromToken(String word) {
        String term = Pattern.compile("[a-zA-Zа-яА-Я]+")
                .matcher(word)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.joining());
        return Pattern.compile("\\b" + Pattern.quote(term) + "\\b", Pattern.CASE_INSENSITIVE);
    }

    /**
     * @param sentence receives a string (sentence) as input
     * @return splits the input string into words by spaces and returns a list of terms (for each word)
     */
    public static List<Pattern> splitStringIntoTerms(String sentence) {
        String[] tokens = sentence.split(" ");
        List<Pattern> result = new ArrayList<>();
        for (String token : tokens) {
            result.add(getTermFromToken(token));
        }
        return result;
    }

    /**
     * @param sentence receives a string (sentence) as input
     * @param term receives a term as input
     * @return counts the number of occurrences of a term in a sentence
     */
    public static int countOccurrences(String sentence, Pattern term) {
        Matcher matcher = term.matcher(sentence);
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * @param docs accepts a corpus of documents as input
     * @param term takes a term as input
     * @return returns a list of document ids, sorted by the frequency of occurrence of the term in the document
     */
    public static List<String> getDocsIdsForTerm(List<Map<String, String>> docs, Pattern term) {
        List<String> result = new ArrayList<>();

        Comparator<Map<String, String>> byWordCount;
        byWordCount = Comparator.comparingInt(doc -> countOccurrences(doc.get("text"), term));

        docs.stream()
                .filter(x -> term.matcher(x.get("text")).find())
                .sorted(byWordCount.reversed())
                .forEach(x -> result.add(x.get("id")));
        return result;
    }

    /**
     * @param term takes a term as input
     * @return returns the original string without the end-of-word characters
     */
    public static String getStringFromTerm(Pattern term) {
        String result = term.toString();
        return result.substring(4, result.length() - 4);
    }

    /**
     * @param text takes a string (sentence) as input
     * @return splits a string into terms and back into strings, returning a list of strings
     * with the goal of adding only pure words to the reverse index without stuck punctuation marks and other things
     */
    public static List<String> parseTextToWords(String text) {
        List<String> result = new ArrayList<>();
        List<Pattern> terms = splitStringIntoTerms(text);
        for (Pattern term : terms) {
            result.add(getStringFromTerm(term));
        }
        return result;
    }
}

package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TermUtils {
    /**
     * @param word accepts a string as input
     * @return only letters from the string, adds a word terminator at the beginning and end,
     * and returns the term
     */
    public static String getTermFromToken(String word) {
        return Pattern.compile("\\w+")
                .matcher(word)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.joining());
    }

    /**
     * @param sentence receives a string (sentence) as input
     * @return splits the input string into words by spaces and returns a list of terms (for each word)
     */
    public static List<String> splitStringIntoTerms(String sentence) {
        String[] tokens = sentence.split(" ");
        List<String> result = new ArrayList<>();
        for (String token : tokens) {
            result.add(getTermFromToken(token));
        }
        return result;
    }

    /**
     * @param text receives a string (text) as input
     * @param term receives a term as input
     * @return counts the number of occurrences of a term in a text
     */
    public static int countOccurrences(String text, String term) {
        List<String> words = splitStringIntoTerms(text);
        int count = 0;
        for (String word : words) {
            if (word.equals(term)) {
                count++;
            }
        }
        return count;
    }

//    /**
//     * @param docs accepts a corpus of documents as input
//     * @param term takes a term as input
//     * @return a list of document ids, sorted by the frequency of occurrence of the term in the document
//     */
//    public static List<String> getDocsIdsForTerm(List<Map<String, String>> docs, Pattern term) {
//        List<String> result = new ArrayList<>();
//
//        Comparator<Map<String, String>> byWordCount;
//        byWordCount = Comparator.comparingInt(doc -> countOccurrences(doc.get("text"), term));
//
//        docs.stream()
//                .filter(x -> term.matcher(x.get("text")).find())
//                .sorted(byWordCount.reversed())
//                .forEach(x -> result.add(x.get("id")));
//        return result;
//    }

//    /**
//     * @param term takes a term as input
//     * @return the original string without the end-of-word characters
//     */
//    public static String getWordFromTerm(Pattern term) {
//        String result = term.toString();
//        return result.substring(4, result.length() - 4);
//    }

    /**
     * @param text takes a string (sentence) as input
     * @return splits a string into terms and back into strings, returning a list of strings
     * with the goal of adding only pure words to the reverse index without stuck punctuation marks and other things
     */
    public static List<String> parseTextToWords(String text) {
        String[] tokens = text.split(" ");
        List<String> result = new ArrayList<>();
        for (String token : tokens) {
            result.add(getTermFromToken(token));
        }
        return result;
    }
}

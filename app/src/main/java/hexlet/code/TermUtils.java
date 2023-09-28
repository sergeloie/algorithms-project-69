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
                .collect(Collectors.joining()).toLowerCase();
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
}

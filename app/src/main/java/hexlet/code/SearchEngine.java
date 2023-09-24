package hexlet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchEngine {
    public static List<String> search(List<Map<String, String>> docs, String str) {
        List<String> result = new ArrayList<>();
        Pattern pattern = getTermFromToken(str);

        Comparator<Map<String, String>> byWordCount;
        byWordCount = Comparator.comparingInt(doc -> countOccurrences(doc.get("text"), str));

        docs.stream()
                .filter(x -> pattern.matcher(x.get("text")).find())
                .sorted(byWordCount.reversed())
                .forEach(x -> result.add(x.get("id")));
        return result;
    }

    public static int countOccurrences(String sentence, String word) {
        Pattern pattern = getTermFromToken(word);
        Matcher matcher = pattern.matcher(sentence);
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static Pattern getTermFromToken(String word) {
        String term = Pattern.compile("[a-zA-Z]+")
                .matcher(word)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.joining());
        return Pattern.compile("\\b" + Pattern.quote(term) + "\\b", Pattern.CASE_INSENSITIVE);
    }

    public static List<Pattern> splitStringIntoTerms(String sentence) {
        String[] tokens = sentence.split(" ");
        List<Pattern> result = new ArrayList<>();
        for(String token : tokens) {
            result.add(getTermFromToken(token));
        }
        return result;
    }
}

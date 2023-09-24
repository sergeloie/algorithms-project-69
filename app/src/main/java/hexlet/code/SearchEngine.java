package hexlet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchEngine {
    public static List<String> search(List<Map<String, String>> docs, String str) {
        List<Pattern> termsList = TermUtils.splitStringIntoTerms(str);
        List<String> occurrenceCounter = new ArrayList<>();
        List<String> result;
        for (Pattern term : termsList) {
            occurrenceCounter.addAll(TermUtils.getDocsIdsForTerm(docs, term));
        }
        result = occurrenceCounter.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return result;

    }

//    public static int countOccurrences(String sentence, String word) {
//        Pattern pattern = TermUtils.getTermFromToken(word);
//        Matcher matcher = pattern.matcher(sentence);
//        int count = 0;
//
//        while (matcher.find()) {
//            count++;
//        }
//        return count;
//    }

//    public static List<String> getDocsIdForWord(List<Map<String, String>> docs, String word) {
//        List<String> result = new ArrayList<>();
//        Pattern pattern = TermUtils.getTermFromToken(word);
//
//        Comparator<Map<String, String>> byWordCount;
//        byWordCount = Comparator.comparingInt(doc -> countOccurrences(doc.get("text"), word));
//
//        docs.stream()
//                .filter(x -> pattern.matcher(x.get("text")).find())
//                .sorted(byWordCount.reversed())
//                .forEach(x -> result.add(x.get("id")));
//        return result;
//    }

}

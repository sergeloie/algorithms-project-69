package hexlet.code;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    /**
     * @param list takes as input a list of strings that may contain repetitions
     * @return returns a list of unique strings, sorted by the number of occurrences in the original list
     */
    public static List<String> collapseListOfDifferentStringsIntoSortedListOfUniqueStrings(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

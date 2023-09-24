package hexlet.code;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> collapseListOfDifferentStringsIntoSortedListOfUniqueStrings(List<String> list) {
        return list.stream()//Stream<String>
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

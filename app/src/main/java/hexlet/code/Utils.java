package hexlet.code;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    /**
     * @param list принимает на вход список строк, где могут быть повторения
     * @return возвращает список уникальных строк, отсортированных по количеству вхождений в исходный список
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

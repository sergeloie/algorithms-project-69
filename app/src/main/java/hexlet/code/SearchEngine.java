package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static hexlet.code.Utils.collapseListOfDifferentStringsIntoSortedListOfUniqueStrings;

public class SearchEngine {
     /**
     * @param docs принимает на вход корпус документов
     * @param str принимает на вход строку (предложение)
     * @return возвращает список докуметов, где встречается любое из слов,
     * отсортированный по количеству вхождения слов в документы
     */
    public static List<String> search(List<Map<String, String>> docs, String str) {
        List<Pattern> termsList = TermUtils.splitStringIntoTerms(str);
        List<String> occurrenceCounter = new ArrayList<>();

        for (Pattern term : termsList) {
            occurrenceCounter.addAll(TermUtils.getDocsIdsForTerm(docs, term));
        }

        return collapseListOfDifferentStringsIntoSortedListOfUniqueStrings(occurrenceCounter);
    }
}

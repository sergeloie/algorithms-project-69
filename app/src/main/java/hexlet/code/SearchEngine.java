package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.TFIDF.getSimpleTFIDFList;
import static hexlet.code.TFIDF.getTFIDFList;

public class SearchEngine {
     /**
     * @param docs принимает на вход корпус документов
     * @param str принимает на вход строку (предложение)
     * @return возвращает список докуметов, где встречается любое из слов,
     * отсортированный по количеству вхождения слов в документы
     */
//    public static List<String> search(List<Map<String, String>> docs, String str) {
//        List<Pattern> termsList = TermUtils.splitStringIntoTerms(str);
//        List<String> occurrenceCounter = new ArrayList<>();
//
//        for (Pattern term : termsList) {
//            occurrenceCounter.addAll(TermUtils.getDocsIdsForTerm(docs, term));
//        }
//
//        return collapseListOfDifferentStringsIntoSortedListOfUniqueStrings(occurrenceCounter);
//    }

    public static List<String> search(List<Map<String, String>> docs, String str) {
        var result1 = getTFIDFList(docs, str);
        var result2 = getSimpleTFIDFList(result1);
        return result2;
    }
}

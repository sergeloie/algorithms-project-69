package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.TFIDF.getSimpleTFIDFList;
import static hexlet.code.TFIDF.getTFIDFList;

public class SearchEngine {
     /**
      * @param docs accepts a corpus of documents as input
      * @param str takes a string (sentence) as input
      * @return returns a list of documents where any of the words occur
      * sorted by the number of occurrences of words in documents
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

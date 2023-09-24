package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static hexlet.code.TermUtils.getStringFromTerm;
import static hexlet.code.Utils.collapseListOfDifferentStringsIntoSortedListOfUniqueStrings;

public class SearchEngine {
    public static List<String> search(List<Map<String, String>> docs, String str) {
        List<Pattern> termsList = TermUtils.splitStringIntoTerms(str);
        List<String> occurrenceCounter = new ArrayList<>();

        for (Pattern term : termsList) {

            System.out.println(term.toString());
            System.out.println(getStringFromTerm(term));

            occurrenceCounter.addAll(TermUtils.getDocsIdsForTerm(docs, term));
        }

        return collapseListOfDifferentStringsIntoSortedListOfUniqueStrings(occurrenceCounter);
    }

//    public static List<String> search(List<Map<String, String>> docs, Pattern term) {
//
//    }

}

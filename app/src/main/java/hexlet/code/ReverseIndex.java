package hexlet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.TermUtils.splitStringIntoTerms;

public class ReverseIndex {
    /**
     * @param index takes as input the Reverse Index
     * @param word takes a word as input
     * @param docId takes the document identifier as input
     * adds a word and a list of documents where it occurs to the Reverse Index
     */
    public static void appendReverseIndex(Map<String, List<String>> index, String word, String docId) {
        if (!index.containsKey(word)) {
            index.put(word, new ArrayList<>(Collections.singleton(docId)));
        } else {
            List<String> list = index.get(word);
            if (!list.contains(docId)) {
                list.add(docId);
            }
        }
    }

    /**
     * @param docs accepts a corpus of documents as input
     * @return builds a reverse index for the document corpus
     */
    public static Map<String, List<String>> createReverseIndex(List<Map<String, String>> docs) {
        Map<String, List<String>> result = new HashMap<>();
        for (Map<String, String> doc : docs) {
            String docId = doc.get("id");
            String text = doc.get("text");
            List<String> words = splitStringIntoTerms(text);
            for (String word : words) {
                appendReverseIndex(result, word, docId);
            }
        }
        return result;
    }
}

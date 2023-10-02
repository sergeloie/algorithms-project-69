package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.ReverseIndex.doReverseIndex;
import static hexlet.code.TFIDF2.getSortedDocList;


public class SearchEngine {

    /**
     * @param docs accepts a corpus of documents as input
     * @param sentence takes a sentence as input
     * @return returns a list of documents where any of the words occur sorted by TF-IDF score
     */
    public static List<String> search(List<Map<String, String>> docs, String sentence) {

        Map<String, Long> reversIndex = doReverseIndex(docs);
        return getSortedDocList(docs, reversIndex, sentence);

    }
}

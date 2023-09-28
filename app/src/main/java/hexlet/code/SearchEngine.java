package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.ScoreDQ.scoreDQ;


public class SearchEngine {

    /**
     * @param docs accepts a corpus of documents as input
     * @param sentence takes a sentence as input
     * @return returns a list of documents where any of the words occur sorted by TF-IDF score
     */
    public static List<String> search(List<Map<String, String>> docs, String sentence) {
//        final Map<String, List<String>> reverseIndex = createReverseIndex(docs);
//        var result1 = getSentenceTFIDFList(docs, sentence);
//        List<String> simpleTFIDFList = getSimpleTFIDFList(result1);
        List<String> result = scoreDQ(docs, sentence);
        System.out.println(sentence);
        System.out.println(result);
        return result;
    }
}

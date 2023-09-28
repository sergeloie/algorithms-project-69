package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.ReverseIndex.createReverseIndex;
import static hexlet.code.TFIDF.getSentenceTFIDFList;
import static hexlet.code.TFIDF.getSimpleTFIDFList;


public class SearchEngine {

    /**
     * @param docs accepts a corpus of documents as input
     * @param sentence takes a sentence as input
     * @return returns a list of documents where any of the words occur sorted by TF-IDF score
     */
    public static List<String> search(List<Map<String, String>> docs, String sentence) {

//        System.out.println("beginning docs corpus\n" + docs);
//        System.out.println("beginning search string\n" + sentence);
        final Map<String, List<String>> reverseIndex = createReverseIndex(docs);
        var result1 = getSentenceTFIDFList(docs, sentence);
        List<String> simpleTFIDFList = getSimpleTFIDFList(result1);
//        System.out.println("SentenceTFIDFList = " + result1 + "\n");
//        System.out.println("simpleTFIDFList = " + simpleTFIDFList + "\n");
        return simpleTFIDFList;
    }
}

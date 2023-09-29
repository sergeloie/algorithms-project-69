package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static hexlet.code.ReverseIndex.doReverseIndex;
import static hexlet.code.ScoreDQ.scoreDQ;
import static hexlet.code.SearchEngine.search;

public class SimplTest {

    @Test
    void testSimpleSearch() {
        String doc1 = "Air quality in the sunny island improved gradually throughout Wednesday.";
        String doc2 = "Air quality in Singapore on Wednesday continued to get worse as haze hit the island.";
        String doc3 = "The air quality in Singapore is monitored through a network of air monitoring stations "
                + "located in different parts of the island";
        String doc4 = "The air quality in Singapore got worse on Wednesday.";

        String query = "wednesday singapore";
        List<Map<String, String>> docs = new ArrayList<>();
        docs.add(Map.of("id", "doc1", "text", doc1));
        docs.add(Map.of("id", "doc2", "text", doc2));
        docs.add(Map.of("id", "doc3", "text", doc3));
        docs.add(Map.of("id", "doc4", "text", doc4));

        var index = doReverseIndex(docs);
        List<String> result = search(docs, query);
        System.out.println(result);
        System.out.println(scoreDQ(docs, index, query));

        System.out.println(doReverseIndex(docs));

    }
}

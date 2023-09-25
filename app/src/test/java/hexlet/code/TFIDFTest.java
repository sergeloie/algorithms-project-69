package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static hexlet.code.TFIDF.calculateTFIDF;

class TFIDFTest {

    @Test
    void testCalculateTFIDF() {
        var doc1 = "milk test shake штако";
        var doc2 = "test shake big";
        var doc3 = "big test complete";
        var doc4 = "point pit salomate";

        List<Map<String, String>> docs = List.of(
                Map.of("id", "doc1", "text", doc1),
                Map.of("id", "doc2", "text", doc2),
                Map.of("id", "doc3", "text", doc3),
                Map.of("id", "doc4", "text", doc4)
        );

        String word = "test";

        System.out.println(calculateTFIDF(docs, doc1, word));
    }
}

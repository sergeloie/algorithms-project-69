package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static hexlet.code.ReverseIndex.createReverseIndex;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseIndexTest {

    @Test
    void testCreateReverseIndex() {
        var doc1 = "milk test shake";
        var doc2 = "test shake big";
        var doc3 = "big test complete";

        List<Map<String, String>> docs = List.of(
                Map.of("id", "doc1", "text", doc1),
                Map.of("id", "doc2", "text", doc2),
                Map.of("id", "doc3", "text", doc3)
        );

        String actual = createReverseIndex(docs).toString();
        String expected = "{big=[doc2, doc3], "
                + "shake=[doc1, doc2], test=[doc1, doc2, doc3], milk=[doc1], complete=[doc3]}";
        System.out.println(actual);
        assertEquals(actual, expected);
    }
}

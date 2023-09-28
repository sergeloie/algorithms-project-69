package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchEngineTest {

    @Test
    void search() {
        var doc1 = "I can't shoot straight unless I've had a pint!";
        var doc2 = "Don't shoot shoot shoot that thing pint at me.";
        var doc3 = "shoot at me shoot at me";

        List<Map<String, String>> docs = List.of(
                Map.of("id", "doc1", "text", doc1),
                Map.of("id", "doc2", "text", doc2),
                Map.of("id", "doc3", "text", doc3)
        );
        List<String> result = SearchEngine.search(docs, "me");
        List<String> expected = new ArrayList<>();
        expected.add("doc3");
        expected.add("doc2");
        expected.add("doc1");
        assertEquals(expected, result);
        System.out.println(result);
    }
}

package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class SearchEngineTest {

    @Test
    void search() {
        var doc1 = "I can't shoot straight unless I've had a pint!";
        var doc2 = "Don't shoot shoot shoot that thing at me.";
        var doc3 = "I'm your shooter.";

        List<Map<String, String>> docs = List.of(
                Map.of("id", "doc1", "text", doc1),
                Map.of("id", "doc2", "text", doc2),
                Map.of("id", "doc3", "text", doc3)
        );

        String query = "shoot at me, nerd";
        List<String> result = SearchEngine.search(docs, query);
        System.out.println(result);
    }
}

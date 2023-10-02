package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static hexlet.code.SearchEngine.search;
import static hexlet.code.TFIDF2.getNumberOfWordsInDocument;

public class IDFtest {

    private final String garbagePatchNG = Files.readString(Path.of("src/test/resources/garbage_patch_NG"));
    private final String garbagePatchOceanClean =
            Files.readString(Path.of("src/test/resources/garbage_patch_ocean_clean"));
    private final String garbagePatchWiki = Files.readString(Path.of("src/test/resources/garbage_patch_wiki"));
    private final String garbagePatchSpam = Files.readString(Path.of("src/test/resources/garbage_patch_spam"));
    private final List<Map<String, String>> docs = List.of(
            Map.of("id", "garbage_patch_NG", "text", garbagePatchNG),
            Map.of("id", "garbage_patch_ocean_clean", "text", garbagePatchOceanClean),
            Map.of("id", "garbage_patch_wiki", "text", garbagePatchWiki),
            Map.of("id", "garbage_patch_spam", "text", garbagePatchSpam));

    public IDFtest() throws IOException {
    }

    @Test
    public void testIDF() throws IOException {
        System.out.println(getNumberOfWordsInDocument(Map.of("text", garbagePatchNG)));
        System.out.println(getNumberOfWordsInDocument(Map.of("text", garbagePatchOceanClean)));
        System.out.println(getNumberOfWordsInDocument(Map.of("text", garbagePatchWiki)));
        System.out.println(getNumberOfWordsInDocument(Map.of("text", garbagePatchSpam)));
    }

    @Test
    void testIDF2() throws IOException {
        List<Map<String, String>> docs1 = List.of(
                Map.of("id", "garbage_patch_NG", "text", garbagePatchNG),
                Map.of("id", "garbage_patch_ocean_clean", "text", garbagePatchOceanClean),
                Map.of("id", "garbage_patch_wiki", "text", garbagePatchWiki),
                Map.of("id", "garbagePatchSpam", "text", garbagePatchSpam));
        String sentence = "shoot at me, nerd";
        System.out.println(search(docs1, sentence));
    }

    @Test
    void testIDF3() throws IOException {
    }
}

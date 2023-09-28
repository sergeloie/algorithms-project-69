package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static hexlet.code.TFIDF.calculateWordTFIDF;

public class BigTextTest {

    private final String garbagePatchNG = Files.readString(Path.of("src/test/resources/garbage_patch_NG.txt"));
    private final String garbagePatchOceanClean =
            Files.readString(Path.of("src/test/resources/garbage_patch_ocean_clean.txt"));
    private final String garbagePatchWiki = Files.readString(Path.of("src/test/resources/garbage_patch_wiki.txt"));
    private final String garbagePatchSpam = Files.readString(Path.of("src/test/resources/garbage_patch_spam.txt"));
    private final List<Map<String, String>> docs = List.of(
            Map.of("id", "garbage_patch_NG", "text", garbagePatchNG),
            Map.of("id", "garbage_patch_ocean_clean", "text", garbagePatchOceanClean),
            Map.of("id", "garbage_patch_wiki", "text", garbagePatchWiki),
            Map.of("id", "garbage_patch_spam", "text", garbagePatchSpam)
    );

    public BigTextTest() throws IOException {
    }

    @Test
    void bigTextTest() throws IOException {

        String fullString = "the trash island is a";
        String shortString = "trash";

        String expected = "[garbage_patch_NG, garbage_patch_ocean_clean, garbage_patch_wiki, garbage_patch_spam]";

        List<String> result = SearchEngine.search(docs, fullString);
        List<String> result2 = SearchEngine.search(docs, shortString);
        System.out.println(expected);
        System.out.println(result);
        System.out.println(result2);


    }

    @Test
    void testCalculateWordTFIDF() throws IOException {
        System.out.println(calculateWordTFIDF(docs, garbagePatchNG, "trash"));

    }


}

package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class BigTextTest {

    @Test
    void bigTextTest() throws IOException {
        String garbagePatchNG = Files.readString(Path.of("src/test/resources/garbage_patch_NG.txt"));

        String garbagePatchOceanClean = Files.readString(Path.of("src/test/resources/garbage_patch_ocean_clean.txt"));

        String garbagePatchWiki = Files.readString(Path.of("src/test/resources/garbage_patch_wiki.txt"));

        String garbagePatchSpam = Files.readString(Path.of("src/test/resources/garbage_patch_spam.txt"));

        String search = "the trash island is a";

        List<Map<String, String>> docs = List.of(
                Map.of("id", "garbage_patch_NG", "text", garbagePatchNG),
                Map.of("id", "garbage_patch_ocean_clean", "text", garbagePatchOceanClean),
                Map.of("id", "garbage_patch_wiki", "text", garbagePatchWiki),
                Map.of("id", "garbage_patch_spam", "text", garbagePatchSpam)
        );

        String expected = "[garbage_patch_NG, garbage_patch_ocean_clean, garbage_patch_wiki, garbage_patch_spam]";

        List<String> result = SearchEngine.searchtfidf(docs, search);
        System.out.println(result);


    }


}

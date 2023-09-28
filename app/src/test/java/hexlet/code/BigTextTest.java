package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static hexlet.code.ReverseIndex.createReverseIndex;
import static hexlet.code.TFIDF.*;

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
    private final List<Map<String, String>> docs1 = List.of(
            Map.of("id", "garbage_patch_NG", "text", garbagePatchNG),
            Map.of("id", "garbage_patch_ocean_clean", "text", garbagePatchOceanClean),
            Map.of("id", "garbage_patch_wiki", "text", garbagePatchWiki)
    );

    public BigTextTest() throws IOException {
    }

    @Test
    void bigTextTest() throws IOException {

        String fullString = "trash island";
//        String shortString = "trash";

        String expected1 = "[garbage_patch_NG, garbage_patch_ocean_clean, garbage_patch_wiki]";
        String expected = "[garbage_patch_NG, garbage_patch_ocean_clean, garbage_patch_wiki, garbage_patch_spam]";

        List<String> result = SearchEngine.search(docs1, fullString);
//        List<String> result2 = SearchEngine.search(docs, shortString);
        System.out.println(expected1);
        System.out.println(result);
//        System.out.println(result2);


    }

    @Test
    void testCalculateWordTFIDF() throws IOException {
        System.out.println(calculateWordTF(garbagePatchNG, "trash"));
        System.out.println(calculateWordTF(garbagePatchOceanClean, "trash"));
        System.out.println(calculateWordTF(garbagePatchWiki, "trash"));

        System.out.println("calculateWordIDF = " + calculateWordIDF(docs1, "plastic"));

        System.out.println(calculateWordTFIDF(docs1, garbagePatchNG, "trash"));
        System.out.println(calculateWordTFIDF(docs1, garbagePatchNG, "island"));
        System.out.format("%.06f", calculateSentenceTFIDF(docs1, garbagePatchNG, "trash island"));


        System.out.println(calculateWordTFIDF(docs1, garbagePatchOceanClean, "trash"));
        System.out.println(calculateWordTFIDF(docs1, garbagePatchOceanClean, "island"));
        System.out.format("%.6f", calculateSentenceTFIDF(docs1, garbagePatchOceanClean, "trash island"));


        System.out.println(calculateWordTFIDF(docs1, garbagePatchWiki, "trash"));
        System.out.println(calculateWordTFIDF(docs1, garbagePatchWiki, "island"));
        System.out.println(calculateSentenceTFIDF(docs1, garbagePatchWiki, "trash island"));

    }

    @Test
    void testReverseIndex() {
        var reverseIndex = createReverseIndex(docs);
        System.out.println(reverseIndex);
    }


}

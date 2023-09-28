package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static hexlet.code.ReverseIndex.createReverseIndex;
import static hexlet.code.TFIDF.calculateDocLength;
import static hexlet.code.TFIDF.calculateSentenceTFIDF;
import static hexlet.code.TFIDF.calculateWordIDF;
import static hexlet.code.TFIDF.calculateWordTF;
import static hexlet.code.TFIDF.calculateWordTFIDF;
import static hexlet.code.TFIDF.scoreDQ;

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
        System.out.format("%.06f", calculateSentenceTFIDF(docs1, garbagePatchNG, "trash island islands"));


        System.out.println(calculateWordTFIDF(docs1, garbagePatchOceanClean, "trash"));
        System.out.println(calculateWordTFIDF(docs1, garbagePatchOceanClean, "island"));
        System.out.format("%.6f", calculateSentenceTFIDF(docs1, garbagePatchOceanClean, "trash island islands"));


        System.out.println(calculateWordTFIDF(docs1, garbagePatchWiki, "trash"));
        System.out.println(calculateWordTFIDF(docs1, garbagePatchWiki, "island"));
        System.out.println(calculateSentenceTFIDF(docs1, garbagePatchWiki, "trash island islands"));

    }

    @Test
    void testReverseIndex() {
        var reverseIndex = createReverseIndex(docs);
        System.out.println(reverseIndex);
//        System.out.println(countOccurrences(garbagePatchNG, "trash"));
        System.out.println(calculateDocLength(garbagePatchNG));
    }

    @Test
    void testTFIDF() {
        String mass = "mass";
        String count = "count";
        String masscount = "trash island";
//        System.out.println(calculateWordTF(garbagePatchNG, mass));
//        System.out.println(calculateWordTF(garbagePatchOceanClean, mass));
//        System.out.println(calculateWordTF(garbagePatchWiki, mass));
//        System.out.println(calculateWordTF(garbagePatchSpam, mass));
//
//
//
//        System.out.println(calculateWordTFIDF(docs, garbagePatchNG, mass));
//        System.out.println(calculateWordTFIDF(docs, garbagePatchOceanClean, mass));
//        System.out.println(calculateWordTFIDF(docs, garbagePatchWiki, mass));
//        System.out.println(calculateWordTFIDF(docs, garbagePatchSpam, mass));
//
//        System.out.println(calculateWordIDF(docs, mass));
//        System.out.println(calculateWordIDF(docs, count));
//
//        System.out.println(calculateAvarageDocLength(docs));

        System.out.println(scoreDQ(docs1, garbagePatchNG, masscount));
        System.out.println(scoreDQ(docs1, garbagePatchOceanClean, masscount));
        System.out.println(scoreDQ(docs1, garbagePatchWiki, masscount));
//        System.out.println(scoreDQ(docs1, garbagePatchSpam, masscount));

    }


}

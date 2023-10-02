package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static hexlet.code.ReverseIndex.doReverseIndex;
import static hexlet.code.TFIDF2.getNumberOfWordsInDocument;
import static hexlet.code.TFIDF2.getSortedDocList;
import static hexlet.code.TFIDF2.sortIndex;

public class TFIDF2Test {

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

    public TFIDF2Test() throws IOException {

    }

    @Test
    void tFIDFTest() throws IOException {
        System.out.println(getNumberOfWordsInDocument(Map.of("text", garbagePatchNG)));
        System.out.println(getNumberOfWordsInDocument(Map.of("text", garbagePatchOceanClean)));
        System.out.println(getNumberOfWordsInDocument(Map.of("text", garbagePatchWiki)));
        System.out.println(getNumberOfWordsInDocument(Map.of("text", garbagePatchSpam)));
    }

    @Test
    void reverseIndexTest() throws IOException {

        var index = doReverseIndex(docs);
        System.out.println(getSortedDocList(docs, index, "trash island"));
    }

    @Test
    void sortTest() {
        List<Map<String, Double>> xxx = new ArrayList<>();
        xxx.add(Map.of("a", 3.0));
        xxx.add(Map.of("b", 1.0));
        xxx.add(Map.of("c", 2.0));
        xxx.add(Map.of("d", 4.0));
        System.out.println(sortIndex(xxx));

    }
}

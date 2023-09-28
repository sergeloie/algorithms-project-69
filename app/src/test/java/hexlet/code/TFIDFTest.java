package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static hexlet.code.TFIDF.calculateWordIDF;
import static hexlet.code.TFIDF.calculateDocLength;
import static hexlet.code.TFIDF.calculateWordTF;
import static hexlet.code.TFIDF.calculateWordTFIDF;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TFIDFTest {
    private String doc1 = "milk test shake borg";
    private String doc2 = "test shake big";
    private String doc3 = "big test complete elephant mortal";
    private String doc4 = "point pit";

    private List<Map<String, String>> docs = List.of(
            Map.of("id", "doc1", "text", doc1),
            Map.of("id", "doc2", "text", doc2),
            Map.of("id", "doc3", "text", doc3),
            Map.of("id", "doc4", "text", doc4)
    );

    private String word1 = "test";
    private String word2 = "shake";
    private String word3 = "elephant";
    private String word4 = "point";


    @Test
    void testCalculateTFIDF() {

        System.out.println(calculateWordTFIDF(docs, doc1, word1));
    }

    @Test
    void tESTcalculateNumberOfWords() {
        assertEquals(4, calculateDocLength(doc1));
        assertEquals(3, calculateDocLength(doc2));
        assertEquals(5, calculateDocLength(doc3));
        assertEquals(2, calculateDocLength(doc4));
    }

    @Test
    void tESTcalculateTF() {
        assertEquals(0.25, calculateWordTF(doc1, word1), 0.001);
        assertEquals(0.3333333, calculateWordTF(doc2, word1), 0.001);
        assertEquals(0.2, calculateWordTF(doc3, word1), 0.001);
        assertEquals(0.0, calculateWordTF(doc4, word1), 0.001);

        assertEquals(0.3333333, calculateWordTF(doc2, word2), 0.001);
        assertEquals(0.2, calculateWordTF(doc3, word3), 0.001);
        assertEquals(0.5, calculateWordTF(doc4, word4), 0.001);
    }

    @Test
    void tESTcalculateIDF() {
        assertEquals(0.125, calculateWordIDF(docs, word1), 0.001);
        assertEquals(0.301, calculateWordIDF(docs, word2), 0.001);
        assertEquals(0.602, calculateWordIDF(docs, word3), 0.001);
        assertEquals(0.602, calculateWordIDF(docs, word4), 0.001);
    }

    @Test
    void tESTcalculateTFIDF() {
        assertEquals(0.031, calculateWordTFIDF(docs, doc1, word1), 0.001);
        assertEquals(0.1, calculateWordTFIDF(docs, doc2, word2), 0.001);
        assertEquals(0.12, calculateWordTFIDF(docs, doc3, word3), 0.001);
        assertEquals(0.301, calculateWordTFIDF(docs, doc4, word4), 0.001);
    }

    @Test
    void tESTgetSimpleTFIDFList() {
    }
}

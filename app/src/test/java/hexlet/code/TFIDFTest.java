package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static hexlet.code.TFIDF.calculateIDF;
import static hexlet.code.TFIDF.calculateNumberOfWords;
import static hexlet.code.TFIDF.calculateTF;
import static hexlet.code.TFIDF.calculateTFIDF;
import static hexlet.code.TFIDF.getSimpleTFIDFList;
import static hexlet.code.TFIDF.getTFIDFList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TFIDFTest {
    private String doc1 = "milk test shake штако";
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

        System.out.println(calculateTFIDF(docs, doc1, word1));
    }

    @Test
    void tESTcalculateNumberOfWords() {
        assertEquals(4, calculateNumberOfWords(doc1));
        assertEquals(3, calculateNumberOfWords(doc2));
        assertEquals(5, calculateNumberOfWords(doc3));
        assertEquals(2, calculateNumberOfWords(doc4));
    }

    @Test
    void tESTcalculateTF() {
        assertEquals(0.25, calculateTF(doc1, word1), 0.001);
        assertEquals(0.3333333, calculateTF(doc2, word1), 0.001);
        assertEquals(0.2, calculateTF(doc3, word1), 0.001);
        assertEquals(0.0, calculateTF(doc4, word1), 0.001);

        assertEquals(0.3333333, calculateTF(doc2, word2), 0.001);
        assertEquals(0.2, calculateTF(doc3, word3), 0.001);
        assertEquals(0.5, calculateTF(doc4, word4), 0.001);
    }

    @Test
    void tESTcalculateIDF() {
        assertEquals(0.125, calculateIDF(docs, word1), 0.001);
        assertEquals(0.301, calculateIDF(docs, word2), 0.001);
        assertEquals(0.602, calculateIDF(docs, word3), 0.001);
        assertEquals(0.602, calculateIDF(docs, word4), 0.001);
    }

    @Test
    void tESTcalculateTFIDF() {
        assertEquals(0.031, calculateTFIDF(docs, doc1, word1), 0.001);
        assertEquals(0.1, calculateTFIDF(docs, doc2, word2), 0.001);
        assertEquals(0.12, calculateTFIDF(docs, doc3, word3), 0.001);
        assertEquals(0.301, calculateTFIDF(docs, doc4, word4), 0.001);
    }

    @Test
    void tESTgetTFIDFList() {
        // Calculate TF-IDF for "test"
        List<Map<String, Double>> tfidfListTest1 = getTFIDFList(docs, word1);
        System.out.println(tfidfListTest1);
        List<String> resultListTest1 = getSimpleTFIDFList(tfidfListTest1);
        System.out.println(resultListTest1);
        assertEquals(List.of("doc2", "doc1", "doc3", "doc4"), resultListTest1);

        List<Map<String, Double>> tfidfListTest2 = getTFIDFList(docs, word2);
        List<String> resultListTest2 = getSimpleTFIDFList(tfidfListTest2);
        System.out.println(tfidfListTest2);
        System.out.println(resultListTest2);
        assertEquals(List.of("doc2", "doc1", "doc3", "doc4"), resultListTest2);

        List<Map<String, Double>> tfidfListTest3 = getTFIDFList(docs, word3);
        List<String> resultListTest3 = getSimpleTFIDFList(tfidfListTest3);
        System.out.println(tfidfListTest3);
        System.out.println(resultListTest3);
        assertEquals(List.of("doc3", "doc1", "doc2", "doc4"), resultListTest3);


        List<Map<String, Double>> tfidfListTest4 = getTFIDFList(docs, word4);
        List<String> resultListTest4 = getSimpleTFIDFList(tfidfListTest4);
        System.out.println(tfidfListTest4);
        System.out.println(resultListTest4);
        assertEquals(List.of("doc4", "doc1", "doc2", "doc3"), resultListTest4);
    }

    @Test
    void tESTgetSimpleTFIDFList() {
    }
}

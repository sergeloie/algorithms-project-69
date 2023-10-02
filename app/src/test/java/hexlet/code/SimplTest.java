//package hexlet.code;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import static hexlet.code.ReverseIndex.doReverseIndex;
//import static hexlet.code.SearchEngine.search;
//import static hexlet.code.TFIDF2.getIDF;
//import static hexlet.code.TFIDF2.getSentenceTFIDF;
//import static hexlet.code.TFIDF2.getTF;
//import static hexlet.code.TFIDF2.getWordTFIDF;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class SimplTest {
//
//    @Test
//    void testSimpleSearch() {
//        String doc1 = "Air quality in the sunny island improved gradually throughout Wednesday.";
//        String doc2 = "Air quality in Singapore on Wednesday continued to get worse as haze hit the island.";
//        String doc3 = "The air quality in Singapore is monitored through a network of air monitoring stations "
//                + "located in different parts of the island";
//        String doc4 = "The air quality in Singapore got worse on Wednesday.";
//
//        String w = "wednesday";
//        String s = "singapore";
//        String ws = "wednesday singapore";
//        List<Map<String, String>> docs = new ArrayList<>();
//        docs.add(Map.of("id", "doc1", "text", doc1));
//        docs.add(Map.of("id", "doc2", "text", doc2));
//        docs.add(Map.of("id", "doc3", "text", doc3));
//        docs.add(Map.of("id", "doc4", "text", doc4));
//
//        var index = doReverseIndex(docs);
//
//        System.out.println(getTF(docs.get(0), s));
//        System.out.println(getTF(docs.get(1), s));
//        System.out.println(getTF(docs.get(2), s));
//        System.out.println(getTF(docs.get(3), s));
//
//        assertEquals(getTF(docs.get(0), w), 0.1, 0.001);
//        assertEquals(getTF(docs.get(1), w), 0.06666666666666667, 0.001);
//        assertEquals(getTF(docs.get(2), w), 0.0, 0.001);
//        assertEquals(getTF(docs.get(3), w), 0.1111111111111111, 0.001);
//
//        assertEquals(getTF(docs.get(0), s), 0.0, 0.001);
//        assertEquals(getTF(docs.get(1), s), 0.06666666666666667, 0.001);
//        assertEquals(getTF(docs.get(2), s), 0.047619047619047616, 0.001);
//        assertEquals(getTF(docs.get(3), s), 0.1111111111111111, 0.001);
//
////        assertEquals(getIDF(docs, index, w), 0.125, 0.001);
////        assertEquals(getIDF(docs, index, s), 0.125, 0.001);
//
//        assertEquals(getWordTFIDF(docs, docs.get(0), index, w), 0.0125, 0.001);
//        assertEquals(getWordTFIDF(docs, docs.get(1), index, w), 0.008333333333333333, 0.001);
//        assertEquals(getWordTFIDF(docs, docs.get(2), index, w), 0, 0.001);
//        assertEquals(getWordTFIDF(docs, docs.get(3), index, w), 0.013888888888888888, 0.001);
//
//        assertEquals(getWordTFIDF(docs, docs.get(0), index, s), 0, 0.001);
//        assertEquals(getWordTFIDF(docs, docs.get(1), index, s), 0.008333333333333333, 0.001);
//        assertEquals(getWordTFIDF(docs, docs.get(2), index, s), 0.00625, 0.001);
//        assertEquals(getWordTFIDF(docs, docs.get(3), index, s), 0.013888888888888888, 0.001);
//
//
//        assertEquals(getSentenceTFIDF(docs, docs.get(0), index, w), 0.0125, 0.001);
//        assertEquals(getSentenceTFIDF(docs, docs.get(1), index, w), 0.008333333333333333, 0.001);
//        assertEquals(getSentenceTFIDF(docs, docs.get(2), index, w), 0, 0.001);
//        assertEquals(getSentenceTFIDF(docs, docs.get(3), index, w), 0.013888888888888888, 0.001);
//
//        assertEquals(getSentenceTFIDF(docs, docs.get(0), index, s), 0, 0.001);
//        assertEquals(getSentenceTFIDF(docs, docs.get(1), index, s), 0.008333333333333333, 0.001);
//        assertEquals(getSentenceTFIDF(docs, docs.get(2), index, s), 0.00625, 0.001);
//        assertEquals(getSentenceTFIDF(docs, docs.get(3), index, s), 0.013888888888888888, 0.001);
//
//
//
//        assertEquals(getSentenceTFIDF(docs, docs.get(0), index, ws), 0.0125, 0.001);
//        assertEquals(getSentenceTFIDF(docs, docs.get(1), index, ws), 0.016666666666666667, 0.001);
//        assertEquals(getSentenceTFIDF(docs, docs.get(2), index, ws), 0.00625, 0.001);
//        assertEquals(getSentenceTFIDF(docs, docs.get(3), index, ws), 0.02777777777, 0.001);
//
//        System.out.println(search(docs, ws));
//        assertEquals(search(docs, ws), List.of("doc4", "doc2", "doc1", "doc3"));
//
//
//
//
//
//    }
//
//
//}

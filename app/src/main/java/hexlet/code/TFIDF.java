package hexlet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static hexlet.code.ReverseIndex.createReverseIndex;
import static hexlet.code.TermUtils.splitStringIntoTerms;

public class TFIDF {

    public static int calculateDocLength(String doc) {
        return splitStringIntoTerms(doc).size();
    }

    public static double calculateWordTF(String doc, String word) {
        double numTF = TermUtils.countOccurrences(doc, TermUtils.getTermFromToken(word));
        double denTF = calculateDocLength(doc);
        return numTF / denTF;
    }

    public static double calculateWordIDF(List<Map<String, String>> docs, String word) {
        double numIDF = docs.size();
        Map<String, List<String>> reverseIndex = createReverseIndex(docs);
        double denIDF = reverseIndex.get(word).size();
        return Math.log10(numIDF / denIDF);
    }

    public static double calculateWordTFIDF(List<Map<String, String>> docs, String doc, String word) {
        double tf = calculateWordTF(doc, word);
        double idf = calculateWordIDF(docs, word);
        return tf * idf;
    }

    public static double calculateSentenceTFIDF(List<Map<String, String>> docs, String doc, String sentence) {
        List<String> words = splitStringIntoTerms(sentence);
        double tfidf = 0;
        for (String word : words) {
            tfidf += calculateWordTFIDF(docs, doc, word);
        }
        return tfidf;
    }

    public static List<Map<String, Double>> getSentenceTFIDFList(List<Map<String, String>> docs, String sentence) {
        List<Map<String, Double>> result = new ArrayList<>();
        for (Map<String, String> doc : docs) {
            double x = scoreDQ(docs, doc.get("text"), sentence);
            System.out.printf("%s - %01.20f%n", doc.get("id"), x);
            result.add(Map.of(doc.get("id"), x));
        }
        Comparator<Map<String, Double>> byDoubleCount;
        byDoubleCount = Comparator.comparingDouble(m -> m.entrySet().iterator().next().getValue());
        return result.stream()
                .sorted(byDoubleCount.reversed())
                .collect(Collectors.toList());
    }

    public static List<Map<String, Double>> getWordTFIDFList(List<Map<String, String>> docs, String word) {
        List<Map<String, Double>> result = new ArrayList<>();
        for (Map<String, String> doc : docs) {
            double x = calculateWordTFIDF(docs, doc.get("text"), word);
            System.out.println(x);
            result.add(Map.of(doc.get("id"), x));
        }
        Comparator<Map<String, Double>> byDoubleCount;
        byDoubleCount = Comparator.comparingDouble(m -> m.entrySet().iterator().next().getValue());
        return result.stream()
                .sorted(byDoubleCount.reversed())
                .collect(Collectors.toList());
    }

    public static List<String> getSimpleTFIDFList(List<Map<String, Double>> tfidfList) {

        return tfidfList.stream()
                .map(m -> m.entrySet().iterator().next().getKey())
                .toList();

    }

    public static double scoreDQ(List<Map<String, String>> docs, String doc, String sentence) {
        double k = 2;
        double b = 0.75;
        double score = 0;
        List<String> words = splitStringIntoTerms(sentence);
        System.out.println(words);
        for (String word : words) {
            //          System.out.println(word);
            double tf = calculateWordTF(doc, word);
            double idf = calculateWordIDF(docs, word);
            score += idf
                    * (tf * (k + 1))
                    * (tf + k * (1 - b + b * calculateDocLength(doc) / calculateAvarageDocLength(docs)));

        }
        return score;
    }

    public static long calculateAvarageDocLength(List<Map<String, String>> docs) {
        // calculate average length of documents
        long totalLength = 0;
        for (Map<String, String> doc : docs) {
            totalLength += splitStringIntoTerms(doc.get("text")).size();
        }
        return totalLength / docs.size();
    }



}

package hexlet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static hexlet.code.ReverseIndex.createReverseIndex;

public class TFIDF {

    public static int calculateNumberOfWords(String doc) {
        return TermUtils.splitStringIntoTerms(doc).size();
    }

    public static double calculateTF(String doc, String word) {
        double numTF = TermUtils.countOccurrences(doc, TermUtils.getTermFromToken(word));
        double denTF = calculateNumberOfWords(doc);
        return numTF / denTF;
    }

    public static double calculateIDF(List<Map<String, String>> docs, String word) {
        double numIDF = docs.size();
        Map<String, List<String>> reverseIndex = createReverseIndex(docs);
        double denIDF = reverseIndex.get(word).size();
        return Math.log10(numIDF / denIDF);
    }

    public static double calculateTFIDF(List<Map<String, String>> docs, String doc, String word) {
        double tf = calculateTF(doc, word);
        double idf = calculateIDF(docs, word);
        return tf * idf;
    }

    public static List<Map<String, Double>> getTFIDFList(List<Map<String, String>> docs, String word) {
        List<Map<String, Double>> result = new ArrayList<>();
        for (Map<String, String> doc : docs) {
            double x = calculateTFIDF(docs, doc.get("text"), word);
            System.out.println(x);
            result.add(Map.of(doc.get("id"), x));

        }

        Comparator<Map<String, Double>> byDoubleCount;
        byDoubleCount = Comparator.comparingDouble(m -> m.entrySet().iterator().next().getValue());
        var someList =  result.stream()
//                .sorted(Comparator.comparingDouble(m -> m.entrySet().iterator().next().getValue()))
                .sorted(byDoubleCount.reversed())
                .collect(Collectors.toList());

//        someList.sort(Comparator.comparing(m -> m.values().stream().findFirst().orElse(0.0),
//                Comparator.reverseOrder()));
        return someList;


    }

    public static List<String> getSimpleTFIDFList(List<Map<String, Double>> tfidfList) {
        List<String> result = new ArrayList<>();
        result = tfidfList.stream()
                .map(m -> m.entrySet().iterator().next().getKey())
                .toList();
        return result;
    }



}

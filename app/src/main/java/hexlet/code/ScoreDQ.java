package hexlet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static hexlet.code.TermUtils.splitStringIntoTerms;

public class ScoreDQ {
    public static List<String> scoreDQ(List<Map<String, String>> docs, String sentence) {

        List<Map<String, Double>> result = new ArrayList<>();
        double k = 2;
        double b = 0.75;

        long avgDocLength = calculateAvarageDocLength(docs);
        List<String> words = splitStringIntoTerms(sentence);
        for (Map<String, String> doc : docs) {
            String docId = doc.get("id");
            String docText = doc.get("text");
            int docLength = TFIDF.calculateDocLength(docText);
            double score = 0;
            for (String word : words) {
                double tf = TFIDF.calculateWordTF(docText, word);
                double idf = TFIDF.calculateWordIDF(docs, word);
                score += idf * (tf * (k + 1)) * (tf + k * (1 - b + b * docLength / avgDocLength));
            }
            result.add(Map.of(docId, score));
        }
        Comparator<Map<String, Double>> byDoubleCount;
        byDoubleCount = Comparator.comparingDouble(m -> m.entrySet().iterator().next().getValue());


        return result.stream()
                .sorted(byDoubleCount.reversed())
                .map(x -> x.entrySet().iterator().next().getKey())
                .collect(Collectors.toList());
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

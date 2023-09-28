package hexlet.code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProbeTFIDF {

    public static List<String> search(List<Map<String, String>> docs, String sentence) {
        List<Map<String, String>> corpus = new ArrayList<>();
        String query = "sample text for calculation";

        List<String> sortedIds = calculateTFIDF(docs, sentence);
        System.out.println("Sorted IDs: " + sortedIds);
        return sortedIds;

    }


    public static List<String> calculateTFIDF(List<Map<String, String>> corpus, String query) {
        List<String> sortedIds = new ArrayList<>();
        Map<String, Double> tfidfMap = new HashMap<>();
        int totalDocuments = corpus.size();

        // Разбиваем предложение на отдельные слова
        List<String> queryWords = Arrays.asList(query.toLowerCase().split("\\s+"));

        // Расчет TF-IDF для каждого текста в корпусе
        for (Map<String, String> text : corpus) {
            String id = text.get("id");
            String content = text.get("text");

            List<String> words = Arrays.asList(content.toLowerCase().split("\\s+"));

            // Расчет TF для каждого слова в тексте
            Map<String, Double> termFrequency = new HashMap<>();
            for (String word : words) {
                double tf = calculateTermFrequency(word, words);
                termFrequency.put(word, tf);
            }

            // Расчет IDF для каждого слова в тексте
            Map<String, Double> inverseDocumentFrequency = new HashMap<>();
            for (String word : queryWords) {
                double idf = calculateInverseDocumentFrequency(word, corpus);
                inverseDocumentFrequency.put(word, idf);
            }

            // Расчет TF-IDF для каждого слова и сумма TF-IDF
            double totalTFIDF = 0.0;
            for (String word : queryWords) {
                double tf = termFrequency.getOrDefault(word, 0.0);
                double idf = inverseDocumentFrequency.getOrDefault(word, 0.0);
                double tfidfValue = tf * idf;
                totalTFIDF += tfidfValue;
            }

            tfidfMap.put(id, totalTFIDF);
        }

        // Сортировка идентификаторов текстов по значению TF-IDF
        sortedIds = new ArrayList<>(tfidfMap.keySet());
        sortedIds.sort(Comparator.comparingDouble(tfidfMap::get).reversed());

        return sortedIds;
    }

    // Расчет Term Frequency (частота слова в тексте)
    private static double calculateTermFrequency(String word, List<String> words) {
        long frequency = words.stream().filter(w -> w.equalsIgnoreCase(word)).count();
        double tf = (double) frequency / words.size();
        return tf;
    }

    // Расчет Inverse Document Frequency (обратная частота документа)
    private static double calculateInverseDocumentFrequency(String word, List<Map<String, String>> corpus) {
        long documentsWithWord = corpus.stream()
                .map(text -> text.get("text").toLowerCase())
                .filter(content -> content.contains(word.toLowerCase()))
                .count();

        if (documentsWithWord > 0) {
            double idf = Math.log((double) corpus.size() / documentsWithWord);
            return idf;
        } else {
            return 0.0;
        }
    }
}



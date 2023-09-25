package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.ReverseIndex.createReverseIndex;
import static hexlet.code.TermUtils.*;

public class TFIDF {

    public static int calculateNumberOfWords(String doc) {
        return splitStringIntoTerms(doc).size();
    }

    public static double calculateTF(String doc, String word) {
        double numTF = countOccurrences(doc, getTermFromToken(word));
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


}

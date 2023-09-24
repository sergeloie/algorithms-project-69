package hexlet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.TermUtils.parseTextToWords;

public class ReverseIndex {
    /**
     * @param index принимает на вход Обратный Индекс
     * @param word принимает на вход слово
     * @param docId принимает на вход идентификатор документа
     * @append добавляет к Обратному Индексу слово и список документов, где оно встречается
     */
    public static void appendReverseIndex(Map<String, List<String>> index, String word, String docId) {
        if (!index.containsKey(word)) {
            index.put(word, new ArrayList<>(Collections.singleton(docId)));
        } else {
            List<String> list = index.get(word);
            if (!list.contains(docId)) {
                list.add(docId);
            }
        }
    }

    /**
     * @param docs принимает на вход корпус документов
     * @return строит для коруса документов обратный индекс
     */
    public static Map<String, List<String>> createReverseIndex(List<Map<String, String>> docs) {
        Map<String, List<String>> result = new HashMap<>();
        for (Map<String, String> doc : docs) {
            String docId = doc.get("id");
            String text = doc.get("text");
            List<String> words = parseTextToWords(text);
            for (String word : words) {
                appendReverseIndex(result, word, docId);
            }
        }
        return result;
    }
}

package hexlet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TermUtils {
    /**
     * @param word принимает на вход строку
     * @return извлекает из строки только буквы, добавляет в начале и в конце признак конца слова и возвращает терм
     */
    public static Pattern getTermFromToken(String word) {
        String term = Pattern.compile("[a-zA-Zа-яА-Я]+")
                .matcher(word)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.joining());
        return Pattern.compile("\\b" + Pattern.quote(term) + "\\b", Pattern.CASE_INSENSITIVE);
    }

    /**
     * @param sentence получает на вход строку (предложение)
     * @return делит входную строку на слова по пробелам и возвращает список термов (для каждого слова)
     */
    public static List<Pattern> splitStringIntoTerms(String sentence) {
        String[] tokens = sentence.split(" ");
        List<Pattern> result = new ArrayList<>();
        for (String token : tokens) {
            result.add(getTermFromToken(token));
        }
        return result;
    }

    /**
     * @param sentence получает на вход строку (предложение)
     * @param term получает на вход терм
     * @return считает количество вхождений терма в предложение
     */
    public static int countOccurrences(String sentence, Pattern term) {
        Matcher matcher = term.matcher(sentence);
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * @param docs принимает на вход корпус документов
     * @param term принимает на вход терм
     * @return возвращает список id документов, отсортированный по частоте вхождения терма в документ
     */
    public static List<String> getDocsIdsForTerm(List<Map<String, String>> docs, Pattern term) {
        List<String> result = new ArrayList<>();

        Comparator<Map<String, String>> byWordCount;
        byWordCount = Comparator.comparingInt(doc -> countOccurrences(doc.get("text"), term));

        docs.stream()
                .filter(x -> term.matcher(x.get("text")).find())
                .sorted(byWordCount.reversed())
                .forEach(x -> result.add(x.get("id")));
        return result;
    }

    /**
     * @param term принимает на вход терм
     * @return возвращает исходную строку без спецсимволов конца слова
     */
    public static String getStringFromTerm(Pattern term) {
        String result = term.toString();
        return result.substring(4, result.length() - 4);
    }

    /**
     * @param text принимает на вход строку (предложение)
     * @return разбивает строку на термы и обратно в строки, возвращает список строк
     * с целью, добавлять в обратный индекс только чистые слова без прилипших знаков препинания и прочего
     */
    public static List<String> parseTextToWords(String text) {
        List<String> result = new ArrayList<>();
        List<Pattern> terms = splitStringIntoTerms(text);
        for (Pattern term : terms) {
            result.add(getStringFromTerm(term));
        }
        return result;
    }
}

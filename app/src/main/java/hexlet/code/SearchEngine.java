package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SearchEngine {
    public static List<String> search(List<Map<String, String>> docs, String str) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(str) + "\\b", Pattern.CASE_INSENSITIVE);

        docs.stream()
                .filter(x -> pattern.matcher(x.get("text")).find())
                .forEach(x -> result.add(x.get("id")));
        return result;
    }
}

package backend.academy.model;

import backend.academy.utils.JsonReader;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.Map;

public class HintRepository {
    private final static Map<String, String> HINTS;

    static {
        try {
            HINTS = JsonReader.readJsonFile("src/main/resources/hints.json", new TypeToken<Map<String, String>>() {
            }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getHint(String word) {
        return HINTS.get(word);
    }

    private HintRepository() {
    }
}

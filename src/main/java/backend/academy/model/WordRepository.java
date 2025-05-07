package backend.academy.model;

import backend.academy.utils.JsonReader;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("HideUtilityClassConstructor")
public class WordRepository {
    private final static Map<String, String[][]> WORDS;

    static {
        try {
            WORDS = JsonReader.readJsonFile("src/main/resources/words.json",
                new TypeToken<Map<String, String[][]>>() {
                }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Set<String> getCategories() {
        return WORDS.keySet();
    }

    public static int getCountLevels(String category) {
        return WORDS.get(category).length;
    }

    public static int getCountWordsInLevels(String category, int level) {
        return WORDS.get(category)[level].length;
    }

    public static boolean categoryExist(String category) {
        return WORDS.containsKey(category);
    }

    public static String getWord(String category, int level, int index) {
        String word = WORDS.get(category)[level][index];
        return word;
    }

}

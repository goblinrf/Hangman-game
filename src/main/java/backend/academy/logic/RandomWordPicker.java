package backend.academy.logic;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static backend.academy.model.WordRepository.getCategories;
import static backend.academy.model.WordRepository.getCountLevels;
import static backend.academy.model.WordRepository.getCountWordsInLevels;

public class RandomWordPicker {
    private static final Random RANDOM_SELECTOR = new SecureRandom();

    public String getRandomCategory() {
        List<String> keys = new ArrayList<>(getCategories());
        return keys.get(RANDOM_SELECTOR.nextInt(keys.size()));
    }

    public int getRandomLevel(String category) {
        return RANDOM_SELECTOR.nextInt(getCountLevels(category));
    }

    public int getRandomIndex(String category, int level) {
        return RANDOM_SELECTOR.nextInt(getCountWordsInLevels(category, level));
    }
}

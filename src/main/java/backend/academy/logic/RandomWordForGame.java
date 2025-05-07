package backend.academy.logic;

import backend.academy.model.WordRepository;

public class RandomWordForGame {
    private final RandomWordPicker randomWordPicker;

    public RandomWordForGame() {
        this.randomWordPicker = new RandomWordPicker();
    }

    public String getRandomWord(String category, int level) {
        int index = randomWordPicker.getRandomIndex(category, level);
        return WordRepository.getWord(category, level, index);
    }
}

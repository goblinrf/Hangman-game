package backend.academy.validation;

public class WordValidator {
    private static final int MIN_LENGTH_WORD = 2;

    public static void validateWordLength(String word) {
        if (word.length() < MIN_LENGTH_WORD) {
            throw new IllegalArgumentException("Загадываемое слово должно быть длиной не менее 2 символов.");
        }
    }

    private WordValidator() {
    }
}

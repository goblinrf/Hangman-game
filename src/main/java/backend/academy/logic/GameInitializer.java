package backend.academy.logic;

import backend.academy.enums.DifficultyLevel;
import backend.academy.printer.Printer;
import backend.academy.printer.PrinterFactory;
import backend.academy.reader.ReaderGameParams;
import backend.academy.validation.WordValidator;

@SuppressWarnings("ConstantName")
public class GameInitializer {
    private static final Printer printer = PrinterFactory.createPrinter();

    public GameState initializeGame() {
        RandomWordPicker randomWordPicker = new RandomWordPicker();
        RandomWordForGame randomWordForGame = new RandomWordForGame();
        ReaderGameParams readerGameParams = new ReaderGameParams();
        String category = readerGameParams.readCategory();
        if (category.isEmpty()) {
            category = randomWordPicker.getRandomCategory();
        }
        printer.println("Была выбрана категория: " + category);

        DifficultyLevel level = readerGameParams.readDifficultyLevel(category);

        printer.printf("Был выбран уровень: %d", level.ordinal());
        char[] wishWord = randomWordForGame.getRandomWord(category, level.ordinal()).toCharArray();
        WordValidator.validateWordLength(new String(wishWord));
        int maxAttempts = level.getAttempts();
        return new GameState(wishWord, maxAttempts);
    }
}

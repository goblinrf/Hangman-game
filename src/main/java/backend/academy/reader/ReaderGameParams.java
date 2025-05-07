package backend.academy.reader;

import backend.academy.enums.DifficultyLevel;
import backend.academy.logic.GameState;
import backend.academy.logic.RandomWordPicker;
import backend.academy.model.WordRepository;
import backend.academy.printer.Printer;
import backend.academy.printer.PrinterFactory;
import backend.academy.utils.ScannerUtils;
import backend.academy.validation.ValidationOutput;
import java.util.function.Function;

@SuppressWarnings({"RegexpSinglelineJava", "ConstantName"})
public class ReaderGameParams {
    private static final Printer printer = PrinterFactory.createPrinter();

    public String readCategory() {
        String category;
        printer.println(WordRepository.getCategories());
        do {
            category = ScannerUtils.getInput("Введите название категории (нажмите Enter "
                + "если хотите получить случайную категорию): ", Function.identity()).toLowerCase();
        }
        while (!ValidationOutput.validationCategory(category));
        return category;
    }

    public DifficultyLevel readDifficultyLevel(String category) {
        String levelInput;
        do {
            levelInput = ScannerUtils.getInput("Введите уровень сложности от 0 до 2 "
                + "(или оставьте пустым для случайного): ", Function.identity());
        } while (!ValidationOutput.validationLevel(levelInput));

        if (levelInput.isEmpty()) {
            return DifficultyLevel.fromLevel(new RandomWordPicker().getRandomLevel(category));
        }
        return DifficultyLevel.fromLevel(Integer.parseInt(levelInput));
    }


    public static String readLetter(GameState gameState) {
        String input;
        do {
            input = ScannerUtils.getInput("Введите букву (введите 'подсказка', "
                + "чтобы получить её): ", Function.identity()).toLowerCase();
        } while (!ValidationOutput.validationLetter(gameState, input));
        return input;
    }

    public ReaderGameParams() {
    }
}

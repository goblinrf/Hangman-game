package backend.academy.validation;

import backend.academy.enums.DifficultyLevel;
import backend.academy.logic.GameState;
import backend.academy.model.WordRepository;
import backend.academy.printer.Printer;
import backend.academy.printer.PrinterFactory;

@SuppressWarnings({"RegexpSinglelineJava", "ConstantName"})
public class ValidationOutput {
    private static final Printer printer = PrinterFactory.createPrinter();
    private static final int MIN_DIFFICULTY_LEVEL = 0;

    public static boolean validationCategory(String category) {
        if (category.isEmpty()) {
            return true;
        }
        if (!WordRepository.categoryExist(category)) {
            printer.println("Ошибка! Введите существующую категорию");
            return false;
        }

        return true;
    }

    public static boolean validationLevel(String level) {
        if (level.isEmpty()) {
            return true;
        }
        try {
            int levelInt = Integer.parseInt(level);
            if (levelInt < MIN_DIFFICULTY_LEVEL || levelInt > DifficultyLevel.values().length - 1) {
                printer.println("Неверный уровень, выберите от 0 до 2.");
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            printer.println("Ошибка! Нужно вводить число");
            return false;
        }
    }

    public static boolean validationLetter(GameState gameState, String str) {
        String russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String lowerStr = str.toLowerCase();

        if ("подсказка".equals(lowerStr)) {
            return true;
        }

        if (lowerStr.length() == 1) {
            if (!russianAlphabet.contains(lowerStr)) {
                printer.printf(("Ошибка! Подстрока \"%s\" не входит в "
                    + "русский алфавит."), lowerStr);
                return false;
            } else if (gameState.letterUsed(lowerStr.charAt(0))) {
                printer.println("Ошибка! Буква уже вводилась!");
            } else {
                return true;
            }
        } else {
            System.out.println("Ошибка! Введите 1 букву");
        }

        return false;
    }

    private ValidationOutput() {
    }
}

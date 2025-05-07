package backend.academy.logic;

import backend.academy.model.HintRepository;
import backend.academy.printer.GameStateRenderer;
import backend.academy.printer.HangmanDrawer;
import backend.academy.printer.Printer;
import backend.academy.printer.PrinterFactory;
import backend.academy.reader.ReaderGameParams;
import backend.academy.utils.ScannerUtils;

@SuppressWarnings({"RegexpSinglelineJava", "ConstantName"})
public class GameController {
    private static final Printer printer = PrinterFactory.createPrinter();

    public void startGame() {
        GameInitializer gameInitializer = new GameInitializer();
        GameState gameState = gameInitializer.initializeGame();
        HangmanDrawer hangmanDrawer = new HangmanDrawer(gameState.getAttempts());
        GameStateRenderer.printGameState(gameState, hangmanDrawer);
        while (!gameState.isPlayerWin() && !gameState.isPlayerLose()) {
            String input = ReaderGameParams.readLetter(gameState).toLowerCase();
            if ("подсказка".equalsIgnoreCase(input)) {
                System.out.println(HintRepository.getHint(gameState.getWishWord()));
                continue;
            } else {
                char letter = input.charAt(0);
                gameState.makeGuess(letter);
            }

            GameStateRenderer.printGameState(gameState, hangmanDrawer);
        }

        if (gameState.isPlayerWin()) {
            printer.println("Поздравляем, вы выиграли!");
        } else {
            printer.println("Вы проиграли.");
        }
        ScannerUtils.closeScanner();
    }
}

package backend.academy.printer;

import backend.academy.logic.GameState;

@SuppressWarnings("RegexpSinglelineJava")
public class GameStateRenderer {

    public static void printGameState(GameState gameState, HangmanDrawer hangmanDrawer) {
        System.out.println("Уже введённые буквы:");
        gameState.getPreviousLetters().forEach(l -> System.out.print(Character.toLowerCase(l) + " "));
        System.out.println();
        hangmanDrawer.drawHangman(gameState.getAttempts());
        System.out.println();
        System.out.println("Отгаданная часть:");
        for (char ch : gameState.getGuessedPart()) {
            System.out.print(ch);
        }
        System.out.println();
    }


    private GameStateRenderer() {
    }
}


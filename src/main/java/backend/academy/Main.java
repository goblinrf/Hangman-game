package backend.academy;

import backend.academy.logic.GameController;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {

    public static void main(String[] args) {
        GameController gameLogic = new GameController();
        gameLogic.startGame();
    }
}

package backend.academy.logic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameFinalStateTest {

    private GameState gameState;

    @BeforeEach
    void setUp() {
        char[] word = "test".toCharArray();
        int attempts = 3;
        gameState = new GameState(word, attempts);
    }

    @Test
    void givenExceededAttempts_whenMakeIncorrectGuesses_thenPlayerLoses() {
        gameState.makeGuess('a');
        gameState.makeGuess('b');
        gameState.makeGuess('c');

        assertThat(gameState.isPlayerLose()).isTrue();
    }

    @Test
    void givenAttemptsLeft_whenMakeCorrectGuess_thenPlayerDoesNotLose() {
        gameState.makeGuess('a');

        assertThat(gameState.isPlayerLose()).isFalse();
    }

    @Test
    void givenCorrectGuesses_whenAllLettersGuessed_thenPlayerWins() {
        gameState.makeGuess('t');
        gameState.makeGuess('e');
        gameState.makeGuess('s');

        assertThat(gameState.isPlayerWin()).isTrue();
    }
}

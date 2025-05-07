package backend.academy.logic;

import backend.academy.model.WordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {
    private GameState gameState;
    @BeforeEach
    void setUp() {
        gameState = new GameState(new char[] {'о', 'г', 'у', 'р', 'е', 'ц'},7);
    }

    @Test
    void givenCorrectLetter_whenMakeGuess_thenGuessedPartWithCorrectLetterReturned() {
        char correctLetter = 'Г';

        gameState.makeGuess(correctLetter);

        assertThat(new char[]{'_','г','_','_','_','_'}).isEqualTo(gameState.getGuessedPart());
    }

    @Test
    void givenLetter_whenMakeGuess_thenLetterInPreviousLettersReturned(){
        char correctLetter = 'Б';

        gameState.makeGuess(correctLetter);

        assertThat('б').isIn(gameState.getPreviousLetters());
    }
    @Test
    void givenIncorrectLetter_whenMakeGuess_thenAttemptsDecrease() {
        // Given
        int initialAttempts = gameState.getAttempts();
        char incorrectLetter = 'б';

        // When
        gameState.makeGuess(incorrectLetter);

        // Then
        assertThat(gameState.getAttempts()).isEqualTo(initialAttempts - 1);
    }
}

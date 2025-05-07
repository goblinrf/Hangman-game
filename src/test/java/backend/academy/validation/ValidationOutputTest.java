package backend.academy.validation;

import backend.academy.logic.GameState;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationOutputTest {
    @Test
    public void givenInputLongerAndGameState_ThanOneCharacter_whenValidationLetter_thenReturnsFalse() {
        GameState gameState = new GameState(new char[] {'ё', 'ж'},10);
        String input = "абв";

        boolean result = ValidationOutput.validationLetter(gameState,input);

        assertThat(result).isFalse();

    }
}

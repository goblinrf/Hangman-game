package backend.academy.validation;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WordValidatorTest {

    @Test
    public void givenShortWord_whenValidateWordLength_thenThrowsException() {
        String shortWord = "A";

        assertThatThrownBy(() -> WordValidator.validateWordLength(shortWord))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Загадываемое слово должно быть длиной не менее 2 символов.");
    }

    @Test
    public void givenValidWord_whenValidateWordLength_thenDoesNotThrowException() {
        String validWord = "Apple";

        assertDoesNotThrow(() -> WordValidator.validateWordLength(validWord));
    }
}

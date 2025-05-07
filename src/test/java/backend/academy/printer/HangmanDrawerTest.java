package backend.academy.printer;

import backend.academy.printer.HangmanDrawer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class HangmanDrawerTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private HangmanDrawer hangmanDrawer;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        hangmanDrawer = new HangmanDrawer(6);  // Создаем с максимальным количеством попыток 6
    }

    @Test
    void givenSixAttempts_whenDrawHangman_thenOnlyFrameIsDrawn() {
        int attemptsLeft = 6;

        hangmanDrawer.drawHangman(attemptsLeft);

        assertThat(outputStreamCaptor.toString().trim())
            .contains("+---+")
            .contains("|   |")
            .contains("     |")
            .contains("======");
    }

    @Test
    void givenFiveAttempts_whenDrawHangman_thenNoHead() {
        int attemptsLeft = 5;

        hangmanDrawer.drawHangman(attemptsLeft);

        assertThat(outputStreamCaptor.toString().trim())
            .contains("+---+")
            .contains("|   |")
            .contains(" O   |")
            .doesNotContain("/|");
    }

    @Test
    void givenZeroAttempts_whenDrawHangman_thenFullFigureIsDrawn() {
        int attemptsLeft = 0;

        hangmanDrawer.drawHangman(attemptsLeft);

        // then - проверяем, что отображается вся фигура
        assertThat(outputStreamCaptor.toString().trim())
            .contains("+---+")
            .contains("|   |")
            .contains(" O   |")
            .contains("/|\\  |")
            .contains("/ \\  |")
            .contains("======");
    }

    @Test
    void givenThreeAttempts_whenDrawHangman_thenPartialFigureWithLeftArm() {
        int attemptsLeft = 3;

        hangmanDrawer.drawHangman(attemptsLeft);

        assertThat(outputStreamCaptor.toString().trim())
            .contains("+---+")
            .contains("|   |")
            .contains(" O   |")
            .contains("/|   |")
            .contains("     |")
            .contains("======");
    }

    @Test
    void givenMoreThanSixAttempts_whenDrawHangman_thenAdditionalFoundationIsDrawn() {
        int maxAttempts = 8;
        HangmanDrawer drawerWithAdditionalBase = new HangmanDrawer(maxAttempts);

        drawerWithAdditionalBase.drawHangman(7);

        assertThat(outputStreamCaptor.toString().trim())
            .contains("+---+")
            .contains("     |")
            .contains("=======");
    }

}

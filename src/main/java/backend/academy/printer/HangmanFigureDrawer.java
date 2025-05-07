package backend.academy.printer;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressWarnings({"RegexpSinglelineJava", "MagicNumber", "ConstantName"})
@SuppressFBWarnings("UCPM_USE_CHARACTER_PARAMETERIZED_METHOD")
public class HangmanFigureDrawer {
    private static final Printer printer = PrinterFactory.createPrinter();

    final static int HANGMAN_ATTEMPTS = 6;
    private static final String TOP_FRAME = " +---+";
    private static final String PIPE = " |   |";
    private static final String HEAD = " O   |";
    private static final String BODY_WITH_ARMS = "/|\\  |";
    private static final String LEFT_ARM = "/|   |";
    private static final String LEFT_LEG = "/    |";
    private static final String LEGS = "/ \\  |";
    private static final String EMPTY_LINE = "     |";
    private static final String BASE = "======";
    private final StringBuilder dopFoundation = new StringBuilder();
    private final int maxAttempts;

    HangmanFigureDrawer(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public void draw(int attemptsLeft) {
        makeDopFoundation(attemptsLeft);
        printer.println(TOP_FRAME);
        printer.println(PIPE);
        switch (attemptsLeft) {
            case 0 -> drawFullFigure(dopFoundation);
            case 1 -> drawFigureWithLeftLeg(dopFoundation);
            case 2 -> drawFigureWithoutLegs(dopFoundation);
            case 3 -> drawFigureWithLeftArm(dopFoundation);
            case 4 -> drawFigureWithoutArms(dopFoundation);
            case 5 -> drawFigureWithoutHead(dopFoundation);
            case 6 -> drawOnlyFrame(dopFoundation);
            default -> drawEmpty(attemptsLeft);
        }

    }

    private void drawFullFigure(StringBuilder dopFoundation) {
        printer.println(HEAD);
        printer.println(BODY_WITH_ARMS);
        printer.println(LEGS);
        printer.println(EMPTY_LINE);
        printer.println(BASE + dopFoundation);
    }

    private void drawFigureWithLeftLeg(StringBuilder dopFoundation) {
        printer.println(HEAD);
        printer.println(BODY_WITH_ARMS);
        printer.println(LEFT_LEG);
        printer.println(EMPTY_LINE);
        printer.println(BASE + dopFoundation);
    }

    private void drawFigureWithoutLegs(StringBuilder dopFoundation) {
        printer.println(HEAD);
        printer.println(BODY_WITH_ARMS);
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.println(BASE + dopFoundation);
    }

    private void drawFigureWithLeftArm(StringBuilder dopFoundation) {
        printer.println(HEAD);
        printer.println(LEFT_ARM);
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.println(BASE + dopFoundation);
    }

    private void drawFigureWithoutArms(StringBuilder dopFoundation) {
        printer.println(HEAD);
        printer.println(PIPE);
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.println(BASE + dopFoundation);
    }

    private void drawFigureWithoutHead(StringBuilder dopFoundation) {
        printer.println(HEAD);
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.println(BASE + dopFoundation);
    }

    private void drawOnlyFrame(StringBuilder dopFoundation) {
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.println(BASE + dopFoundation);
    }

    private void drawEmpty(int attemptsLeft) {
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.println(EMPTY_LINE);
        printer.print(BASE);
        for (int i = 0; i < maxAttempts - attemptsLeft; i++) {
            printer.print("=");
        }
        printer.println("");
    }

    private void makeDopFoundation(int attemptsLeft) {
        if (attemptsLeft == HANGMAN_ATTEMPTS) {
            dopFoundation.append("=".repeat(Math.max(0, maxAttempts - HANGMAN_ATTEMPTS)));
        }
    }
}

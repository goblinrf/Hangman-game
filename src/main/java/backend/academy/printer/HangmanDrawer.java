package backend.academy.printer;

@SuppressWarnings({"RegexpSinglelineJava", "HideUtilityClassConstructor", "ConstantName"})
public class HangmanDrawer {
    private HangmanFigureDrawer figureDrawer;
    private static final Printer printer = PrinterFactory.createPrinter();

    public HangmanDrawer(int maxAttempts) {
        figureDrawer = new HangmanFigureDrawer(maxAttempts);
    }

    public void drawHangman(int attemptsLeft) {
        printer.println("Осталось попыток: " + attemptsLeft);
        figureDrawer.draw(attemptsLeft);
    }
}




package backend.academy.printer;

@SuppressWarnings("HideUtilityClassConstructor")
public class PrinterFactory {
    public static Printer createPrinter() {
        return new Printer();
    }
}

package backend.academy.printer;

@SuppressWarnings("RegexpSinglelineJava")
public class Printer {
    public void println(Object message) {
        System.out.println(message);
    }

    public void printf(String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }

    public void print(Object message) {
        System.out.print(message);
    }

}

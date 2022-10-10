package Lab3.View;

public class ConsoleView implements View {
    @Override
    public void info(String message) {
        System.out.println(message);
    }
}

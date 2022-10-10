package Lab3;
import Lab3.MenuComponent.MenuController;
import Lab3.Model.*;
import Lab3.View.*;
import java.io.IOException;

public class Controller {
    private MenuController menu = new MenuController();
    private Model model = new Model();
    View consoleView = new ConsoleView();

    public Controller() throws IOException {

    }
    public void start() throws IOException {
        menu.start();
        interactionsWithDataBase();
    }
    private void interactionsWithDataBase() throws IOException
    {
        while (true)
        {
            menu.displayOptions();
            switch (model.selectOptions())
            {
                case read -> consoleView.info(model.getRecords());
                case add ->{
                    consoleView.info("q - Выход");
                    model.addRecord();
                }
                case remove -> model.removeRecord();
                case exit -> {
                    model.exit();
                    return;
                }
            }
        }
    }
}

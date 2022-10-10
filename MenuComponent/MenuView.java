package Lab3.MenuComponent;

import Lab3.View.ConsoleView;
import Lab3.View.View;

import java.util.Date;

public class MenuView implements DisplayMenuQuestions {

    private View view = new ConsoleView();
    public MenuView()
    {
    }

    public void hello(String name)
    {
        Date date = new Date();
        view.info("Good "+getPartsOfDay(date.getHours())+name+"!");
    }
    private String getPartsOfDay(int hours)
    {
        if (hours>=0 && hours<=5)
            return "night, ";
        if (hours>=6 && hours<=11)
            return "morning, ";
        if (hours>=12 && hours<=17)
            return "day, ";
        if (hours>=18 && hours<=23)
            return "evening, ";
        return "";
    }
    @Override
    public void askIsCheckLog() {
        view.info("is Log true/false?\n1.true\n2.false");
    }

    @Override
    public void askTypeUser() {
        view.info("Who are you?\n1.root\n2.user");
    }

    @Override
    public void askPassword() { view.info("Please, put password");}

    @Override
    public void askDebugMode() { view.info("Do you want on/off Debug mode?\n1.on\n2.off");}

    @Override
    public void askAutotestMode() { view.info("Do you want on/off Autotest mode?\n1.on\n2.off");}

    @Override
    public void displayError(String error) { view.info(error);}

    public void askOperationsWithDataBase() { view.info("What do u need?\n1. Read records from Data base\n2. Add records to Data base\n3. Remove records by id\n4. Exit");}


    @Override
    public void displayMessage(String message) {
        view.info(message);
    }
}

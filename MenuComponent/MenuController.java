package Lab3.MenuComponent;
import Lab3.ConfigurationComponent.*;
import Lab3.InPutComponent.ConfigInPut;
import Lab3.InPutComponent.ConsoleReader;
import Lab3.LogComponent.Logger;
import Lab3.UserType;

import java.io.IOException;

/**
 * Сущность, контрольрующа меню. Содержит в себе model, который берет данные из Config, и MenuView, класс, выводящий в OutPut информацию
 */
public class MenuController {
    private ConfigurationReader configurationReader = new Config();
    private ConfigurationWriter configurationWriter = new Config();

    private  DisplayMenuQuestions menuView = new MenuView();
    private ConfigInPut configInPut = new ConsoleReader();

    public MenuController() throws IOException {
    }

    public void start() throws IOException {
        hello();
        setIsLogValue();
        signIn();
    }

    /**
     * Вывод меню с опциями
     */
    public void displayOptions()
    {
        menuView.askOperationsWithDataBase();
    }
    private void signIn() throws IOException {
        menuView.askTypeUser();
        if (configInPut.getUserTypeResponse() == UserType.root)
        {
            menuView.askPassword();
            if (configurationReader.isPasswordEmpty())
            {
                String newPassword = "";
                do {
                    newPassword = configInPut.getInputString();
                }while (newPassword.compareTo("")==0);
                configurationWriter.setPassword(newPassword);
                Logger.addLog("User set new password");
            }
            else{
                while (true) {
                    if (configInPut.getInputString().compareTo(configurationReader.getPassword())!=0) {
                        menuView.displayError("Password is not correct");
                    }
                    else
                    {
                        menuView.displayMessage("Sign in...");
                        Logger.addLog("User sign in");
                        break;
                    }
                }
            }
            configurationWriter.setUserType("root");
            setDebugMode();
            setAutotestMode();
        }
        else {
            configurationWriter.setUserType("user ");
        }
    }
    private void setDebugMode() throws IOException {
        menuView.askDebugMode();
        boolean response = configInPut.getBoolResponse();
        configurationWriter.setIsDebug(response);
        Logger.addLog("User set " + response + " Debug mode");
    }
    private void setAutotestMode() throws IOException {
        menuView.askAutotestMode();
        boolean response = configInPut.getBoolResponse();
        configurationWriter.setIsAutoTest(response);
        Logger.addLog("User set " + response + " Autotest mode");
    }

    private void setIsLogValue() throws IOException {
        menuView.askIsCheckLog();
        configurationWriter.setIsLog(configInPut.getBoolResponse());
    }

    /**
     * Вывод приветствия
     * @throws IOException
     */
    private void hello() throws IOException {
        if (configurationReader.nameIsNotEmpty()) {
            String name = configurationReader.getName();
            menuView.hello(name);
            Logger.addLog("User " + name + " logs in");
        }
        else {
            configurationWriter.setName(configInPut.getInputString());
        }
    }


}

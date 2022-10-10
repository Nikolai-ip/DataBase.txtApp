package Lab3.InPutComponent;

import Lab3.Options;
import Lab3.UserType;
import Lab3.Validator;

import java.util.Scanner;

public class ConsoleReader implements RecordInPut, ConfigInPut{
    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();
    @Override
    public String getInputString(){

        return scanner.nextLine();
    }
    @Override
    public UserType getUserTypeResponse() {
        int choice;
        do {
            choice =  validator.inPutNumberValue() - 1;
        } while (choice < 0 || choice >= UserType.values().length);
        return UserType.values()[choice];
    }

    @Override
    public boolean getBoolResponse() {
        switch (validator.inPutNumberValue()){
            case 1: return true;
            case 2: return false;
            default: getBoolResponse();
        }
        return false;
    }

}

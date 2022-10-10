package Lab3;

import java.util.Scanner;

public class SelecterOptions {
    Validator validator = new Validator();
    public DataBaseOption options()
    {
        int choice;
        do {
            choice =  validator.inPutNumberValue() - 1;
        } while (choice < 0 || choice >= DataBaseOption.values().length);

        return DataBaseOption.values()[choice];
    }

}

package Lab3;

import java.util.Scanner;

/**
 * Validator проверяет введено ли корректное значение числа. Пользователь вводит данные, пока данные не соответствуют числу
 */
public class Validator implements IsNumberChecker {
    Scanner scanner = new Scanner(System.in);

    public int inPutNumberValue()
    {
        String choice = "";
        do {
            choice = scanner.nextLine();
        } while(!isNumber(choice));
        return stringParse(choice);
    }
    private int stringParse(String str)
    {
        return Integer.parseInt(str);
    }
    @Override
    public boolean isNumber(String str)
    {
        if (str.isEmpty())
            return false;
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length;i++)
        {
            if ((int)ch[i] < 48 || (int)ch[i] > 57)
            {
                return false;
            }
        }
        return true;
    }
}

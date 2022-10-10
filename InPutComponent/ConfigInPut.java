package Lab3.InPutComponent;


import Lab3.Options;
import Lab3.UserType;

public interface ConfigInPut {
    /**
     * Возвращает напечатанную строку в виде: тип пользователя
     */
    public UserType getUserTypeResponse();
    /**
     * Возвращает напечатанную строку в виде: boolean
     */
    public boolean getBoolResponse();
    /**
     * Возвращает напечатанную строку
     */
    public String getInputString();
}

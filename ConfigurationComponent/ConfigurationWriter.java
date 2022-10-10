package Lab3.ConfigurationComponent;

import java.io.IOException;

public interface ConfigurationWriter {
    /**
     * Задать имя в конфиге.
     * */
    public void setName(String Name) throws IOException;
    /**
     * Включить/выключить режим логгирования.
     * */
    public void setIsLog(Boolean isLog) throws IOException;
    /**
     * Задать пароль в конфиге.
     * */
    public void setPassword(String password) throws IOException;
    /**
     * Задать тип пользователя в конфиге.
     * */
    public void setUserType(String userType) throws IOException;

    /**
     * Включить/выключить режим Откладки.
     * */
    public void setIsDebug(Boolean isDebug) throws IOException;
    /**Включить/выключить режим Автотест.
     * */
    public void setIsAutoTest(Boolean isAutoTest) throws IOException;
}

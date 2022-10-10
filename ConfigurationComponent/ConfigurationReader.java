package Lab3.ConfigurationComponent;

public interface ConfigurationReader {
    /**
     * Показывает включен или выключен режим
     * @return Запись логов включено/выключено в конфиге
     */
    public boolean LogMode();
    /**
     * Показывает включен или выключен режим
     * @return Откладка включена/выключена в конфиге
     */
    public boolean DebugMode();
    /**
     * Показывает включен или выключен режим
     * @return Автотесты включены/выключены в конфиге
     */
    public boolean AutotestMode();
    /**
     * @return Пусто ли поле с паролем в конфиге
     */
    public boolean isPasswordEmpty();
    /**
     * @return Получить пароль из конфига
     */
    public String getPassword();
    /**
     * @return Получить имя из конфига
     */
    public String getName();
    /**
     * @return Получить тип пользователя из конфига
     */
    public String getUserType();
    /**
     * @return Пусто ли поле с именем в конфиге
     */
    public boolean nameIsNotEmpty();

}

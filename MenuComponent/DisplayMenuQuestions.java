package Lab3.MenuComponent;

public interface DisplayMenuQuestions {
    public void askOperationsWithDataBase();
    /**Вывод приветствия*/
    public void hello(String name);
    /**Вывод запроса включение/выключение логирования*/
    public void askIsCheckLog();
    /**Вывод запроса ввода текущего пользователя*/
    public void askTypeUser();
    /**Вывод запроса ввода пороля*/
    public void askPassword();
    /**Вывод запроса включение/выключения режима откладки*/
    public void askDebugMode();
    /**Вывод запроса включение/выключения режима Автотеста*/
    public void askAutotestMode();
    /** Вывод ошибки
     * @param error - ошибки в строковом представлении
     * */
    public void displayError(String error);
    /** Вывод заданной строки*/
    public void displayMessage(String message);
}

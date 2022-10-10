package Lab3.Model;
import Lab3.DataBaseOption;
import Lab3.InPutComponent.*;
import Lab3.LogComponent.*;
import Lab3.SelecterOptions;

import java.io.IOException;

public class Model {
    private RecordInPut console = new ConsoleReader();
    private SelecterOptions select = new SelecterOptions();
    private Adder dataAdder = new DataBaseTxt();
    private Reader dataReader = new DataBaseTxt();
    private Remover dataRemover = new DataBaseTxt();

    public Model() throws IOException {
    }

    public DataBaseOption selectOptions() {
        return select.options();
    }
    /**
     * Возвращает данные из БД
     * Записывает в лог данные о чтении Бд
     * @throws IOException
     */
    public String getRecords() throws IOException {
        Logger.addLog("User read records from DB");
        return dataReader.getNode();
    }
    /**
     * Записывает запись в БД
     * Записывает в лог данные о добавлении записи
     * @throws IOException
     */
    public void addRecord() throws IOException {
        String addRecord = "";
        String line;
        do {
             line = console.getInputString();
             if (line.compareTo("q") == 0)
                 break;
            dataAdder.addNode(line + "\n");
            Logger.addLog("User add record: " + line);
        } while (true);
    }
    public void removeRecord() throws IOException {
        int id = Integer.parseInt(console.getInputString());
        dataRemover.removeRecord(id);
    }
    /**
     * Записывает в лог данные о выходе пользователя
     * @throws IOException
     */
    public void exit() throws IOException {
        Logger.addLog("User exit");
    }
}

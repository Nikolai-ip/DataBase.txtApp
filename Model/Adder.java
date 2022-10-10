package Lab3.Model;

import java.io.IOException;

public interface Adder {
    /**
     * Дабавляет запись в базу данных
     * @param data запись для добавления
     * */
    void addNode(String data) throws IOException;
}

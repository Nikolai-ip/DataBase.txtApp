package Lab3.Model;

import java.io.IOException;

public interface Reader {
    /**
     * Возвращает запись из базы данных
     * @return запись из базы данных
     * */
    String getNode() throws IOException;
}

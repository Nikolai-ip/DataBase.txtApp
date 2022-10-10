package Lab3.Model;

import Lab3.IsNumberChecker;
import Lab3.Validator;

import java.io.*;
import java.util.HashMap;

/**
 * Сущность, читающая и редактирующая Database.txt
 */
public class DataBaseTxt implements Adder, Reader, Remover {

    private File file = new File("Lab3/Data/DataBase.txt");
    private BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
    private HashMap<Integer,String> recordsMap = new HashMap<>();
    private Integer id;

    public DataBaseTxt() throws IOException {
        id = getCountRecords();
    }

    @Override
    public void addNode(String data) throws IOException {
        recordsMap.put(id,data);
        writeNode();
        id++;
    }
    private void writeNode() throws IOException {
        writer.write(id + " : " +  recordsMap.get(id));
        writer.flush();
    }

    private int getCountRecords() throws IOException {
        String records = getNode();
        Integer k = 0;
        for (int i = 0; i < records.length(); i++) {
            if (records.charAt(i) == '\n')
            {
                k++;
            }
        }
        return k;
    }
    @Override
    public String getNode() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String data = "";
        int c;
        while((c = reader.read())!=-1){
            data += (char)c;
        }
        return data;
    }

    @Override
    public void removeRecord(int id) throws IOException {
        recordsMap.remove(id);
    }

}

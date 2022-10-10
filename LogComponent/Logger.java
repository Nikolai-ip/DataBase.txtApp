package Lab3.LogComponent;

import Lab3.ConfigurationComponent.Config;
import Lab3.ConfigurationComponent.ConfigurationReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger{

    private static BufferedWriter writer;
    private static ConfigurationReader config;
    static {
        try {
            config = new Config();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer = new BufferedWriter(new FileWriter("Lab3/Data/Logs.txt",true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Date logCommitTime = new Date();

    public Logger() throws IOException {
    }

    public static void addLog(String log) throws IOException {
        if (config.LogMode())
        {
            writer.write("Log message: " + log + " | Time: " + logCommitTime + "\n");
            writer.flush();
        }
    }
}

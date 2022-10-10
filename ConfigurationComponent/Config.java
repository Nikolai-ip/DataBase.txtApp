package Lab3.ConfigurationComponent;

import Lab3.Program;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Config implements ConfigurationReader, ConfigurationWriter {

    private File fileConfig = new File("Lab3/Data/Config.txt");
    private FileWriter writer =  new FileWriter(fileConfig,true);
    private FileReader reader = new FileReader(fileConfig);
    private enum ConfigsRecord
    {
        Name,
        LogMode,
        Password,
        UserType,
        DebugMode,
        AutotestMode
    }
    private Map<ConfigsRecord,String> configsMap = new HashMap<>();

    private void readConfigs() throws IOException {
        BufferedReader read = new BufferedReader(reader);
        int i = 0;
        while (true)
        {
            String line = read.readLine();
            if (line == null)
                break;
            configsMap.put(ConfigsRecord.values()[i],line);
            i++;
        }
    }


    public Config() throws IOException {
        readConfigs();
    }

    @Override
    public boolean LogMode() {
        switch (configsMap.get(ConfigsRecord.LogMode))
        {
            case "true": return true;
            case "false": return false;
        }
        return false;
    }

    @Override
    public boolean DebugMode() {
        switch (configsMap.get(ConfigsRecord.DebugMode))
        {
            case "true": return true;
            case "false": return false;
        }
        return false;
    }

    @Override
    public boolean AutotestMode() {
        switch (configsMap.get(ConfigsRecord.AutotestMode))
        {
            case "true": return true;
            case "false": return false;
        }
        return false;
    }

    @Override
    public boolean isPasswordEmpty() {
        return configsMap.get(ConfigsRecord.Password).compareTo("")==0;
    }
    @Override
    public boolean nameIsNotEmpty() {
        return configsMap.get(ConfigsRecord.Name).compareTo("")!=0;
    }
    @Override
    public String getPassword() { return configsMap.get(ConfigsRecord.Password);}

    @Override
    public String getName() {return configsMap.get(ConfigsRecord.Name);}

    @Override
    public String getUserType() { return configsMap.get(ConfigsRecord.UserType);}


    @Override
    public void setName(String name) throws IOException {
        configsMap.put(ConfigsRecord.Name,name);
        flesh();
    }

    @Override
    public void setIsLog(Boolean isLog) throws IOException {
        configsMap.put(ConfigsRecord.LogMode,isLog.toString());
        flesh();
    }

    @Override
    public void setPassword(String password) throws IOException {
        configsMap.put(ConfigsRecord.Password,password);
        flesh();
    }

    @Override
    public void setUserType(String userType) throws IOException {
        configsMap.put(ConfigsRecord.UserType,userType);
        flesh();
    }

    @Override
    public void setIsDebug(Boolean isDebug) throws IOException {
        configsMap.put(ConfigsRecord.DebugMode,isDebug.toString());
        flesh();
    }

    @Override
    public void setIsAutoTest(Boolean isAutoTest) throws IOException {
        configsMap.put(ConfigsRecord.AutotestMode,isAutoTest.toString());
        flesh();
    }


    private void flesh() throws IOException {
        FileWriter writer =  new FileWriter(fileConfig,false);
        for (int i = 0; i< ConfigsRecord.values().length; i++)
        {
            writer.write(configsMap.get(ConfigsRecord.values()[i])+"\n");
            writer.flush();
        }
    }
}

package Adapter.Train;

import java.io.FileReader;
import java.util.Properties;

public class FileProperties implements FileIO {
    private Properties properties;

    public void readFromFile(String filename) {
        try {
            properties = new Properties();
            properties.load(new FileReader(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String filename) {
        try {
            properties.store(new java.io.FileWriter(filename), "written by FileProperties");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
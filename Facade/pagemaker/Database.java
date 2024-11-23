package Facade.pagemaker;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() { // newでインスタンス生成させないためにprivateでコンストラクタを定義
    }

    public static Properties getProperties(String dbname) { // データベース名からPropertiesを取得
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileReader(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }

    public static void setProperties(String dbname, Properties prop) { // Propertiesをファイルに保存
        String filename = dbname + ".txt";
        try {
            prop.store(new FileWriter(filename), "written by Database");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

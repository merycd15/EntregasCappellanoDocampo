package Utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    static Properties properties = new Properties();

    public static String getProperty (String data){
        try{
            InputStream input = new FileInputStream("src/main/resources/data.properties");
            properties.load(input);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return properties.getProperty(data);
    }
}

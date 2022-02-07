package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class VariableProperties {
    String URL;
    private static Properties temp;

    private static Properties conf() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("data.properties"));
        temp = properties;
        return temp;
    }

    public String getEmailDev() throws IOException {
        return URL = conf().getProperty("emailDev");
    }

    public String getPassDev() throws IOException {
        return URL = conf().getProperty("passwordDev");
    }
    
    public String getInvalidEmailDev() throws IOException {
        return URL = conf().getProperty("invalidEmailDev");
    }

    public String getInvalidPassDev() throws IOException {
        return URL = conf().getProperty("invalidPasswordDev");
    }

}

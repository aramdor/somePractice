package utils;

import lombok.Data;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Data
@NonNull
public class ApplicationProperties {

    public static final String APP_PROPERTIES_PATH = System.getProperty("user.dir") + "\\target\\classes\\app.properties";
    public static final String browserName = loadProperty("browserName");
    public static final String hostname = loadProperty("hostName");
    public static final String port = loadProperty("port");
    public static final String hub = loadProperty("seleniumGridHub");
    public static final String username = loadProperty("username");
    public static final String password = loadProperty("password");

    public static final String applicationUri = generateApplicationUri();

    private static Logger getLogger() {
        return LoggerFactory.getLogger(ApplicationProperties.class);
    }

    private static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(APP_PROPERTIES_PATH));
        } catch (IOException e) {
            getLogger().error("\nIOException while loading property: " + name + "\n" + e.toString());
        }

        String value = "";

        if (name != null) {
            getLogger().trace("Property " + name + " was found.");
            value = props.getProperty(name);
            getLogger().trace(name + " value is: " + value);
        }
        return value;
    }

    private static String generateApplicationUri() {
        return "http://" + hostname + ":" + port;
    }

}

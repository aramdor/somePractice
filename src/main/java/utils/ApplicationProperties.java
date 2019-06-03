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

    String browserName;
    String hostname;
    String deviceName;
    String port;
    String username;
    String password;
    String applicationUri;
    String hub;

    ApplicationProperties() {
        String APP_PROPERTIES = System.getProperty("user.dir") + "\\target\\classes\\app.properties";
        setBrowserName(loadProperty("browserName", APP_PROPERTIES));
        setHostname(loadProperty("hostName", APP_PROPERTIES));
        setPort(loadProperty("port", APP_PROPERTIES));
        setUsername(loadProperty("username", APP_PROPERTIES));
        setPassword(loadProperty("password", APP_PROPERTIES));
        setHub(loadProperty("seleniumGridHub", APP_PROPERTIES));
        setApplicationUri(generateApplicationUri());
    }

    private Logger getLogger() {
        return LoggerFactory.getLogger(ApplicationProperties.class);
    }

    private String loadProperty(String name, String fileName) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(fileName));
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

    private String generateApplicationUri() {
        return "http://" + getHostname() + ":" + getPort();
    }

}

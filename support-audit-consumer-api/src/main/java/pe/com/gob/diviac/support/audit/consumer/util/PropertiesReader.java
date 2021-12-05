package pe.com.gob.diviac.support.audit.consumer.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertiesReader {

    private static final String FUNCTIONAL_ACTION_PROPERTY_NAME = "functional-action.properties";

    public static String readProperty(String key) {
        InputStream inputStream;
        Properties prop = new Properties();

        try {
            inputStream = PropertiesReader.class.getClassLoader()
                    .getResourceAsStream(FUNCTIONAL_ACTION_PROPERTY_NAME);

            if (inputStream != null) {
                prop.load(inputStream);

                if (prop.containsKey(key)) {
                    return prop.getProperty(key);
                }

                throw new RuntimeException("Unable to find property: " + key);
            }

            throw new RuntimeException("Unable to find property file: " + FUNCTIONAL_ACTION_PROPERTY_NAME);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

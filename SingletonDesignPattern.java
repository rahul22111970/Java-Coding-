//One common use case of the Singleton design pattern in Java is for creating a configuration manager.
//A configuration manager is responsible for reading and providing access to configuration data used by an application. 
// Since configuration data is often used throughout the application, it makes sense to create a singleton class to manage this data.
//Here's an example implementation of a configuration manager using the Singleton pattern:

public class ConfigurationManager {
    private static ConfigurationManager instance;

    private String configFilePath;
    private Properties properties;

    private ConfigurationManager() {
        configFilePath = "config.properties";
        properties = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configFilePath);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

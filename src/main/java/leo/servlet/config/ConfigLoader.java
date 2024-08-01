package leo.servlet.config;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

public class ConfigLoader {
    private static DatabaseConfig databaseConfig;

    static {
        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream("application.yml")) {
            if (inputStream == null) {
                throw new Exception("application.yaml not found");
            } else {
                Yaml yaml = new Yaml();
                ConfigWrapper configWrapper = yaml.loadAs(inputStream, ConfigWrapper.class);
                databaseConfig = configWrapper.getDatabase();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

    public static DatabaseConfig getDatabaseConfig() {
        return databaseConfig;
    }
}

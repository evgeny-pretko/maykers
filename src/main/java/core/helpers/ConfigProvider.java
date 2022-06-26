package core.helpers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String BROWSER = readConfig().getString("browser");

    Integer IMPLICIT_WAIT = readConfig().getInt("timeouts.implicitWait");
    Integer EXPLICIT_WAIT = readConfig().getInt("timeouts.explicitWait");
    Integer PAGE_LOAD = readConfig().getInt("timeouts.pageLoad");

}
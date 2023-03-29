package my.config.autoconfig;

import my.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    @Bean
    ServerProperties serverProperties(Environment env) {
        ServerProperties properties = new ServerProperties();
        properties.setContextPath(env.getProperty("contextPath"));
        properties.setPort(Integer.parseInt(env.getProperty("port")));
        return properties;
    }

}

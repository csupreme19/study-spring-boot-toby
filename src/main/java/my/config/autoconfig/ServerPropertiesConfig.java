package my.config.autoconfig;

import my.config.MyAutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    @Bean
    ServerProperties serverProperties(Environment env) {
        return Binder.get(env)
                .bind("", ServerProperties.class)
                .get();
    }

}

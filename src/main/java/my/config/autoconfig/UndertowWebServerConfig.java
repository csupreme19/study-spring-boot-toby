package my.config.autoconfig;

import my.config.ConditionalMyOnClass;
import my.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("io.undertow.Undertow")
public class UndertowWebServerConfig {

    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory undertowWebServerFactory() {
        return new UndertowServletWebServerFactory();
    }

}

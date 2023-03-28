package my.config.autoconfig;

import my.config.ConditionalMyOnClass;
import my.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory tomcatWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

}

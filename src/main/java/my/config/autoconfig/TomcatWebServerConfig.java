package my.config.autoconfig;

import my.config.ConditionalMyOnClass;
import my.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @Value("${contextPath:}")
    String contextPath;

    @Value("${port}")
    int port;

    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory tomcatWebServerFactory() {
        TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();
        tomcatFactory.setContextPath(contextPath);
        tomcatFactory.setPort(port);

        return tomcatFactory;
    }

}

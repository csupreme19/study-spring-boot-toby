package my.config.autoconfig;

import lombok.RequiredArgsConstructor;
import my.config.MyAutoConfiguration;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@MyAutoConfiguration
@Conditional(UndertowWebServerConfig.UndertowCondition.class)
public class UndertowWebServerConfig {

    @Bean
    public ServletWebServerFactory undertowWebServerFactory() {
        return new UndertowServletWebServerFactory();
    }

    static class UndertowCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return !ClassUtils.isPresent("org.apache.catalina.startup.Tomcat", context.getClassLoader())
                    && ClassUtils.isPresent("io.undertow.Undertow", context.getClassLoader());
        }
    }
}

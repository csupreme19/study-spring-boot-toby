package my.config.autoconfig;

import my.config.MyAutoConfiguration;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@MyAutoConfiguration
@Conditional(TomcatWebServerConfig.TomcatCondition.class)
public class TomcatWebServerConfig {

    @Bean
    public ServletWebServerFactory tomcatWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    static class TomcatCondition implements Condition, BeanClassLoaderAware {

        private ClassLoader classLoader;

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat", classLoader);
        }

        @Override
        public void setBeanClassLoader(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }
    }
}

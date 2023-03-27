package my.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "my.config.autoconfig.TomcatWebServerConfig",
                "my.config.autoconfig.DispatcherServletConfig"
        };
    }
}

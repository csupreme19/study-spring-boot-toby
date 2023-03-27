package my.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

public class MyOnClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String value = String.valueOf(metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName()).get("value"));
        return ClassUtils.isPresent(value, context.getClassLoader());
    }
}

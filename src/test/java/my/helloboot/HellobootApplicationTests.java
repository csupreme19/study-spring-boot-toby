package my.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class HellobootApplicationTests {

    @Autowired
    ListableBeanFactory listableBeanFactory;

    @Test
    void contextLoads() {

        Arrays.stream(listableBeanFactory.getBeanDefinitionNames())
                .forEach(beanName -> System.out.println(String.format("%s=%s", beanName, listableBeanFactory.getBean(beanName))));

    }

}
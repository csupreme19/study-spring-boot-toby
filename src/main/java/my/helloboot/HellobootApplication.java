package my.helloboot;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import my.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@MySpringBootApplication
@RequiredArgsConstructor
//public class HellobootApplication implements InitializingBean {
public class HellobootApplication {

    private final JdbcTemplate jdbcTemplate;

    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println("my.name=" + name);
            String port = env.getProperty("server.port");
            System.out.println("server.port=" + port);
            String url = env.getProperty("data.url");
            System.out.println("data.url=" + url);
        };
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }
}
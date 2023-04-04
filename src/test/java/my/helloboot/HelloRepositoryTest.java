package my.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@HellobootTest
class HelloRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    HelloRepository helloRepository;

    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("HelloA")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("HelloA")).isEqualTo(0);
        helloRepository.increaseCount("HelloA");
        assertThat(helloRepository.countOf("HelloA")).isEqualTo(1);
        helloRepository.increaseCount("HelloA");
        assertThat(helloRepository.countOf("HelloA")).isEqualTo(2);
    }

}
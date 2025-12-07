package jocture.joclearn.application.member.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import jocture.joclearn.domain.member.PasswordEncoder;

@TestConfiguration
public class ApplicationTestConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StubPasswordEncoder();
    }
}

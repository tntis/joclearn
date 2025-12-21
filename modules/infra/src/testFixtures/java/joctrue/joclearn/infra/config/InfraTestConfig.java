package joctrue.joclearn.infra.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import joctrue.joclearn.infra.member.StubPasswordEncoder;
import jocture.joclearn.domain.member.PasswordEncoder;

//@Configuration -> 컴포넌트 스캔 대상 O
@TestConfiguration //-> 컴포넌트 스캔 대상 X
public class InfraTestConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StubPasswordEncoder();
    }
}

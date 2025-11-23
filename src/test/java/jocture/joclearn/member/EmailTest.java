package jocture.joclearn.member;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class EmailTest {
    @Test
    void create(){
        Email email = new Email("susu@co.kr");
        assertThat(email.value()).isEqualTo("susu@co.kr");
    }

    @ParameterizedTest
    @ValueSource(strings= {
        "subin","@qwe.com","sun@q"
    })
    void create_fail(String value) {
        assertThatThrownBy(() -> new Email(value))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
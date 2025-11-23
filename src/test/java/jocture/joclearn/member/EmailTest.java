package jocture.joclearn.member;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmailTest {

    @Test
    void create() {
        Email email = new Email("jocture@gmail.com");
        assertThat(email.value()).isEqualTo("jocture@gmail.com");
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
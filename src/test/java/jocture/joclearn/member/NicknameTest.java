package jocture.joclearn.member;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class NicknameTest {
    @Test
    void create(){
        Nickname nickname = new Nickname("susu");
        assertThat(nickname.value()).isEqualTo("susu");
    }

    @ParameterizedTest
    @ValueSource(strings= {
        "_ed","ssf","1234565w223232e7822345"
    })
    void create_fail(String value ){
        assertThatThrownBy(() -> new Nickname(value))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
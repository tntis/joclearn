package jocture.joclearn.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    Member member;
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        this.passwordEncoder = new PasswordEncoder() {
            @Override
            public String encode(String rawPassword) {
                return rawPassword.toUpperCase();
            }

            @Override
            public boolean matches(String rawPassword, String encodedPassword) {
                return encode(rawPassword).equals(encodedPassword);
            }
        };
        this.member = Member.create("subin", "subin@qwe.com", "abcd1234", passwordEncoder);
    }

    @ParameterizedTest
    @ValueSource(strings= {
        "_ewdw","ssf","1234565678922345345"
    })
    void create_wrongNickname(String nickname ){
        assertThatThrownBy(() -> Member.create(nickname,"subin@qwe.com","dd",passwordEncoder))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings= {
        "subin","@qwe.com","sun@q"
    })
    void create_wrongEmail(String email) {
        assertThatThrownBy(() -> Member.create("subin",email,"dd",passwordEncoder))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        assertThat(member.getStatus()).isEqualTo(MemberStatus.STANDBY);
    }

    @Test
    void activate() {
        member.activate();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }

    @Test
    void deactivate() {
        member.deactivate();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.INACTIVE);
    }

    @Test
    void changePassword() {
        String password = "jocture7890";
        member.changePassword(password, passwordEncoder);
        assertThat(member.getPasswordHash()).isEqualTo(password.toUpperCase());
    }

    @Test
    void verifyPassword() {
        boolean result = member.verifyPassword("abcd1234", passwordEncoder);
        assertThat(result).isTrue();
    }
}

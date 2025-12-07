package jocture.joclearn.domain.member;

public class StubPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(String rawPassword) {
        return rawPassword.toUpperCase();
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}

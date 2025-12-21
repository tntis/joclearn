package joctrue.joclearn.infra.member;

import jocture.joclearn.domain.member.PasswordEncoder;

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

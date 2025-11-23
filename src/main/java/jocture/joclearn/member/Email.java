package jocture.joclearn.member;

import java.util.regex.Pattern;

//VO
public record Email(String value) {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

    public Email {
        validate(value);
    }

    private static void validate(String email) {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("잘못된 이메일 형식입니다.: " + email);
        }
    }
}

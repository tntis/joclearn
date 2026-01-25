package jocture.joclearn.etc.object;

import lombok.ToString;

/**
 * 생성자 사용
 * -> 점층적 생성자 패턴(Telescoping constructor pattern)
 */
@ToString
public class Member2 {

    private final String email;
    private final String nickname;
    private final String phone;
    private final String address;

    public Member2(String email, String nickname) {
        this(email, nickname, null);
    }

    public Member2(String email, String nickname, String phone) {
        this(email, nickname, phone, null);
    }

    public Member2(String email, String nickname, String phone, String address) {
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
    }
}

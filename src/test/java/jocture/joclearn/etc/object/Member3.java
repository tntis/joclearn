package jocture.joclearn.etc.object;

import lombok.ToString;

/**
 * 정적 팩토리 메서드 사용
 */
@ToString
public class Member3 {

    private final String email;
    private final String nickname;
    private final String phone;
    private final String address;

    private Member3(String email, String nickname, String phone, String address) {
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
    }

    public static Member3 withAll(String email, String nickname, String phone, String address) {
        return new Member3(email, nickname, phone, address);
    }

    public static Member3 withBasic(String email, String nickname) {
        return new Member3(email, nickname, null, null);
    }

    public static Member3 withBasicAndPhone(String email, String nickname, String phone) {
        return new Member3(email, nickname, phone, null);
    }

    public static Member3 withBasicAndAddress(String email, String nickname, String address) {
        return new Member3(email, nickname, null, address);
    }
}

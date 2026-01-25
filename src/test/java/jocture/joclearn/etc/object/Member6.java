package jocture.joclearn.etc.object;

import lombok.ToString;

/**
 * 빌더 패턴 - 필수값 지정
 */
@ToString
public class Member6 {

    private final String email;
    private final String nickname;
    private final String phone;
    private final String address;

    private Member6(String email, String nickname, String phone, String address) {
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
    }

    public static Builder withBasic(String email, String nickname) {
        return new Builder(email, nickname);
    }


    public static class Builder {

        private String email;
        private String nickname;
        private String phone;
        private String address;

        private Builder(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Member6 build() {
            return new Member6(email, nickname, phone, address);
        }
    }
}

package jocture.joclearn.etc.object;

import lombok.ToString;

/**
 * 빌더 패턴
 */
@ToString
public class Member5 {

    private final String email;
    private final String nickname;
    private final String phone;
    private final String address;

    private Member5(String email, String nickname, String phone, String address) {
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
    }

    //선택1 - 롬복 구현 방식
    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private String email;
        private String nickname;
        private String phone;
        private String address;

        private Builder() { }

        //선택2
        public static Builder builder() {
            return new Builder();
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Member5 build() {
            return new Member5(email, nickname, phone, address);
        }
    }
}

package jocture.joclearn.etc.object;

import lombok.ToString;

/**
 * 단계별 빌더(Staged Builder)
 */
@ToString
public class Member7 {

    private final String email;
    private final String nickname;
    private final String phone;
    private final String address;

    private Member7(String email, String nickname, String phone, String address) {
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
    }

    public static EmailStep builder() {
        return new Builder();
    }


    public interface EmailStep {

        NicknameStep email(String email);
    }

    public interface NicknameStep {

        OptionalStep nickname(String nickname);
    }

    public interface OptionalStep {

        OptionalStep phone(String nickname);

        OptionalStep address(String nickname);

        Member7 build();
    }


    public static class Builder implements EmailStep, NicknameStep, OptionalStep {

        private String email;
        private String nickname;
        private String phone;
        private String address;

        private Builder() { }

        @Override
        public NicknameStep email(String email) {
            this.email = email;
            return this;
        }

        @Override
        public OptionalStep nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        @Override
        public OptionalStep phone(String phone) {
            this.phone = phone;
            return this;
        }

        @Override
        public OptionalStep address(String address) {
            this.address = address;
            return this;
        }

        @Override
        public Member7 build() {
            return new Member7(email, nickname, phone, address);
        }
    }
}

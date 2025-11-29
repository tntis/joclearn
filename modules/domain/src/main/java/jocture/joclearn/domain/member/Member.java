package jocture.joclearn.domain.member;

import lombok.Getter;

//객체 불변성을 위해 필드에 private final을 선언하는게 좋다.
//하지만 도메인 객체는 불변 객체로 만드는데 제약이 있다.
//물론 불변 객체로 만드는 방법도 있다.
@Getter
public class Member {

    /**
     * 1. 닉네임 규칙과 이메일 규칙을 다른 곳에서도 사용해야 한다면 어떻게 해야할까? 중복 로직?
     * 2. 닉네임, 이메일처럼 자체 검증 로직이 필요한 필드가 많아진다면? Member 객체의 책임이 크고 무거워진다.
     * 3. 부가 로직 때문에 도메인 객체인 Member의 핵심 로직이 잘 보이지 않을 수 있다.
     * - 이런 문제들을 어떻게 해결할 수 있을까?
     */

    private Nickname nickname;
    private Email email;
    private String passwordHash;
    private MemberStatus status;

    private Member(String nickname, String email, String passwordHash, MemberStatus status) {
        this.nickname = new Nickname(nickname);
        this.email = new Email(email);
        this.passwordHash = passwordHash;
        this.status = status;
    }

    public static Member create(String nickname, String email, String password, PasswordEncoder passwordEncoder) {
        return new Member(nickname, email, passwordEncoder.encode(password), MemberStatus.STANDBY);
    }

    public void activate() {
        this.status = MemberStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = MemberStatus.INACTIVE;
    }

    public void changePassword(String newPassword, PasswordEncoder passwordEncoder) {
        this.passwordHash = passwordEncoder.encode(newPassword);
    }

    public boolean verifyPassword(String password, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, passwordHash);
    }
}

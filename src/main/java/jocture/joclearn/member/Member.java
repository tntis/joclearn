package jocture.joclearn.member;

import lombok.Getter;

//객체 불변성을 위해 필드에 private final을 선언하는게 좋다.
//하지만 도메인 객체는 불변 객체로 만드는데 제약이 있다.
//물론 불변 객체로 만드는 방법도 있다.
@Getter
public class Member {

    private String nickname;
    private String email;
    private String passwordHash;
    private MemberStatus status;

    private Member(String nickname, String email, String password, MemberStatus status) {
        this.nickname = nickname;
        this.email = email;
        this.passwordHash = password;
        this.status = status;
    }

    public static Member create(String nickname, String email, String password) {
        return new Member(nickname, email, password, MemberStatus.STANDBY);
    }

    public void activate() {
        this.status = MemberStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = MemberStatus.INACTIVE;
    }
}

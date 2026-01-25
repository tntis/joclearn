package jocture.joclearn.domain.member;

import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

//객체 불변성을 위해 필드에 private final을 선언하는게 좋다.
//하지만 도메인 객체는 불변 객체로 만드는데 제약이 있다.
//물론 불변 객체로 만드는 방법도 있다.
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Integer id;

    /*
      VO 에는 컬럼이 한개라는 보장이 없기때문에 사용하고 여러개일경우에는 array로
      @Embedded
       @AttributeOverrides({
        @AttributeOverride(name= "value",column =  @Column(name = "nickname"))
        @AttributeOverride(name= "value2",column =  @Column(name = "nickname2"))
      })
     */
    @Embedded
    @AttributeOverride(name= "value",column =  @Column(name = "nickname"))
    private Nickname nickname;

    @Embedded
    @AttributeOverride(name= "value",column =  @Column(name = "email"))
    private Email email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "member_status")
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
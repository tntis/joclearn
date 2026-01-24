package jocture.joclearn.etc.object;

import lombok.ToString;

/**
 * 파라미터 객체 사용
 */
@ToString
public class Member4 {

    private final String email;
    private final String nickname;
    private final String phone;
    private final String address;

    private Member4(String email, String nickname, String phone, String address) {
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
    }

    public Member4(BasicInfo basicInfo) {
        this(basicInfo.email(), basicInfo.nickname, null, null);
    }

    public Member4(BasicInfo basicInfo, ExtraInfo extraInfo) {
        this(basicInfo.email(), basicInfo.nickname(), extraInfo.phone(), extraInfo.address());
    }


    public record BasicInfo(String email, String nickname) {
    }

    public record ExtraInfo(String phone, String address) {
    }
}

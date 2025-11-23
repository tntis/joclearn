package jocture.joclearn.member;

import java.util.regex.Pattern;

/*

@ToString
@EqualsAndHashCode
@Getter
@RequiredArgsConstructor

*/
//VO
public record Nickname(String value) {
    private static final Pattern NICKNAME_PATTERN = Pattern.compile("^(?![._-])[A-Za-z0-9._-]{4,20}$");

    public Nickname {
        validate(value);
    }

    //validateXXX() - 유효성 검증 실패 시, Exception 발생; Return 타입은 void
    //checkXXX() - validateXXX() 방식일 수도 있고, 결과를 Return 할 수도 있다.
    // isValidXXX() - 유효성 검증 결과를 boolean 타입으로 Return 한다.
    private void validate(String nickname) {
        if (!NICKNAME_PATTERN.matcher(nickname).matches()) {
            throw new IllegalArgumentException("잘못된 닉네임 형식입니다.: " + nickname);
        }
    }

}

package jocture.joclearn.domain.member.data.dto;

import jocture.joclearn.domain.member.MemberStatus;

public record MemberCondition(
    String nicknameLike,
    String emailLike,
    MemberStatus status
) {

    public static MemberCondition empty() {
        return new MemberCondition(null, null, null);
    }
}

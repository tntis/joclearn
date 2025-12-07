package jocture.joclearn.application.member.data.dto;

import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.PasswordEncoder;

public record MemberJoinRequest(
    String nickname,
    String email,
    String password
) {

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.create(nickname, email, password, passwordEncoder);
    }
}

package jocture.joclearn.application.member.service;

import org.springframework.transaction.annotation.Transactional;
import jocture.joclearn.application.member.data.dto.MemberJoinRequest;
import jocture.joclearn.domain.member.Member;

@Transactional
public interface MemberWriter {

    /** 회원 가입 */
    Member joinMember(MemberJoinRequest request);

    /** 회원정보 수정 */
    void updateMember();

    /** 회원 탈퇴 */
    void leaveMember();
}

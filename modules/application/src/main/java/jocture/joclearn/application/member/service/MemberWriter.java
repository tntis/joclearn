package jocture.joclearn.application.member.service;

public interface MemberWriter {

    /** 회원 가입 */
    void joinMember();

    /** 회원정보 수정 */
    void updateMember();

    /** 회원 탈퇴 */
    void leaveMember();
}

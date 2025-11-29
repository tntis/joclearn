package jocture.joclearn.application.member.service;

public interface MemberReader {

    /** 회원 목록 조회 */
    void getMembers();

    /** 특정 회원 조회 */
    void getMember();
}

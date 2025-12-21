package jocture.joclearn.application.member.service;

import jocture.joclearn.domain.member.Member;

public interface MemberReader {

    /** 회원 목록 조회 */
    void getMembers();

    /** 특정 회원 조회 */
    Member getMember(int memberId);
}

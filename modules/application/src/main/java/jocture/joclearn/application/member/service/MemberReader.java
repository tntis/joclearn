package jocture.joclearn.application.member.service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.data.dto.MemberCondition;

@Transactional(readOnly = true)
public interface MemberReader {

    /** 회원 목록 조회 */
    List<Member> getMembers(MemberCondition condition);

    /** 특정 회원 조회 */
    Member getMember(int memberId);
}

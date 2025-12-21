package jocture.joclearn.domain.member;

import java.util.List;
import java.util.Optional;
import jocture.joclearn.domain.member.data.dto.MemberCondition;

public interface MemberRepository {

    Optional<Member> findById(int memberId);

    Member save(Member member);

    List<Member> findAll(MemberCondition condition);
}

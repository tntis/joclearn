package jocture.joclearn.domain.member;

import java.util.Optional;

public interface MemberRepository {

    Optional<Member> findById(int memberId);

    Member save(Member member);
}

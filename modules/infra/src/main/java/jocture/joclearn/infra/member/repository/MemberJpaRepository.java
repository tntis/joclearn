package jocture.joclearn.infra.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.MemberRepository;

public interface MemberJpaRepository extends MemberRepository, JpaRepository<Member, Integer>, MemberCustomRepository {
}

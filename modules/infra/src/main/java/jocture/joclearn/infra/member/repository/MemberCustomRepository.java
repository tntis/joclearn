package jocture.joclearn.infra.member.repository;

import java.util.List;
import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.data.dto.MemberCondition;

public interface MemberCustomRepository {

    List<Member> findAll(MemberCondition condition);
}

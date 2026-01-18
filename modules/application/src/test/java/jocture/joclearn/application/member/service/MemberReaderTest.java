package jocture.joclearn.application.member.service;

import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import joctrue.joclearn.infra.config.InfraTestConfig;
import jocture.joclearn.domain.common.exception.NotFoundException;
import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.MemberFixtures;
import jocture.joclearn.domain.member.MemberRepository;
import jocture.joclearn.domain.member.data.dto.MemberCondition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
@Import(InfraTestConfig.class)
class MemberReaderTest {

    @Autowired MemberReader memberReader;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    void getMembers() {
        //Given
        memberRepository.save(MemberFixtures.create("joclearn1", "joc1@learn.com"));
        memberRepository.save(MemberFixtures.create("joclearn2", "joc2@learn.com"));
        memberRepository.save(MemberFixtures.create("joclearn3", "joc3@learn.com"));

        //When
        List<Member> result = memberReader.getMembers(MemberCondition.empty());

        //Then
        assertThat(result).hasSize(3);
    }

    @Test
    void getMembers_noList() {
        //Given
        MemberCondition condition = MemberCondition.empty();

        //When
        List<Member> result = memberReader.getMembers(condition);

        //Then
        assertThat(result).isEmpty();
    }

    @Test
    void getMember() {
        //Given
        Member member = memberRepository.save(MemberFixtures.create());
        em.flush();
        em.clear();

        //When
        Member result = memberReader.getMember(member.getId());

        //Then
        assertThat(result.getId()).isNotNull().isEqualTo(member.getId());
        assertThat(result.getNickname()).isEqualTo(member.getNickname());
    }

    @Test
    void getMember_notFound() {
        int noExistsMemberId = -999;
        assertThatThrownBy(() -> memberReader.getMember(noExistsMemberId))
            .isInstanceOf(NotFoundException.class)
            .hasMessageStartingWith("회원을 찾을 수 없습니다.");
    }
}

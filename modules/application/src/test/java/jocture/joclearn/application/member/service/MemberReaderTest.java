package jocture.joclearn.application.member.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import joctrue.joclearn.infra.config.InfraTestConfig;
import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.MemberRepository;
import jocture.joclearn.domain.member.PasswordEncoder;
import jocture.joclearn.domain.member.data.dto.MemberCondition;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Import(InfraTestConfig.class)
class MemberReaderTest {

    @Autowired MemberReader memberReader;
    @Autowired MemberRepository memberRepository;
    @Autowired PasswordEncoder passwordEncoder;

    @Test
    void getMembers() {
        //Given
        MemberCondition condition = MemberCondition.empty();

        //When
        memberReader.getMembers(condition);

        //Then
    }

    @Test
    void getMember() {
        //Given
        Member member = memberRepository.save(Member.create("joclearn", "joc@learn.com", "abcd1234", passwordEncoder));

        //When
        Member result = memberReader.getMember(member.getId());

        //Then
        assertThat(result.getId()).isNotNull().isEqualTo(member.getId());
        assertThat(result.getNickname()).isEqualTo(member.getNickname());
    }
}

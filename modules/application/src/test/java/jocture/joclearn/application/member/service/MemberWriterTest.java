package jocture.joclearn.application.member.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import joctrue.joclearn.infra.config.InfraTestConfig;
import jocture.joclearn.application.member.data.dto.MemberJoinRequest;
import jocture.joclearn.domain.member.Email;
import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.Nickname;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
//@Commit
//@Rollback(false)
// jpa 의 기본은 쓰기지연 (Write-Behind Buffer) flush
@Import(InfraTestConfig.class)
class MemberWriterTest {

    @Autowired MemberWriter memberWriter;

    @Test
    void joinMember() {
        //BDD 패턴 - Given, When, Then

        //Given
        String nicknameValue = "subin";
        String emailValue = "su@re.com";
        String password = "ete";
        MemberJoinRequest request = new MemberJoinRequest(nicknameValue,emailValue,password);
        //When
        Member member = memberWriter.joinMember(request);

        //Then
        assertThat(member.getId()).isPositive();
        assertThat(member.getNickname()).isEqualTo(new Nickname(nicknameValue));
        assertThat(member.getEmail()).isEqualTo(new Email(emailValue));
    }

    @Test
    void updateMember() {
    }

    @Test
    void leaveMember() {
    }
}

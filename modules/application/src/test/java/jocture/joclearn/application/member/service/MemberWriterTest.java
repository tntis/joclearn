package jocture.joclearn.application.member.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jocture.joclearn.application.member.data.dto.MemberJoinRequest;
import jocture.joclearn.domain.member.Email;
import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.Nickname;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberWriterTest {

    @Autowired MemberWriter memberWriter;

    @Test
    void joinMember() {
        String nicknameValue = "subin";
        String emailValue = "su@re.com";
        String password = "ete";
        MemberJoinRequest request = new MemberJoinRequest(nicknameValue,emailValue,password);
        Member member = memberWriter.joinMember(request);

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

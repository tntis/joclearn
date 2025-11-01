package jocture.joclearn.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    Member member;

    @BeforeEach
    void setUp() {
        member = Member.create("jjlim", "jjlim@abc.com", "abcd1234");
    }

    @Test
    void create() {
        assertThat(member.getStatus()).isEqualTo(MemberStatus.STANDBY);
    }

    @Test
    void activate() {
        member.activate();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }

    @Test
    void deactivate() {
        member.deactivate();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.INACTIVE);
    }
}

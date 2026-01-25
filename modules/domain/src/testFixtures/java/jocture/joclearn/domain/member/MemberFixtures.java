package jocture.joclearn.domain.member;


import joctrue.joclearn.infra.member.StubPasswordEncoder;

public abstract class MemberFixtures {

    //점층적 생성자 패턴과 유사한 모양 -> 여기서는 생성자는 아니다!

    public static Member create() {
        //StubPasswordEncoder passwordEncoder = new StubPasswordEncoder();
        //return Member.create("joclearn", "joc@learn.com", "abcd1234", passwordEncoder);
        return create("joclearn", "joc@learn.com");
    }

    public static Member create(String nickname, String email) {
        StubPasswordEncoder passwordEncoder = new StubPasswordEncoder();
        return Member.create(nickname, email, "abcd1234", passwordEncoder);
    }
}

package jocture.joclearn.etc.object;

public class Member1Main {

    static void main() {
        Member1 m1 = new Member1();
        m1.setEmail(MemberConst.EMAIL);
        m1.setNickname(MemberConst.NICKNAME);
        m1.setPhone(MemberConst.PHONE);
        m1.setAddress(MemberConst.ADDRESS);
        System.out.println(">>> m1: " + m1);

        Member1 m2 = new Member1();
        m2.setEmail(MemberConst.EMAIL);
        m2.setNickname(MemberConst.NICKNAME);
        System.out.println(">>> m2: " + m2);
    }
}

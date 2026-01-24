package jocture.joclearn.etc.object;

public class Member2Main {

    static void main() {
        Member2 m1 = new Member2(MemberConst.EMAIL, MemberConst.NICKNAME, MemberConst.PHONE, MemberConst.ADDRESS);
        System.out.println(">>> m1: " + m1);

        Member2 m2 = new Member2(MemberConst.EMAIL, MemberConst.NICKNAME);
        System.out.println(">>> m2: " + m2);

        Member2 m3 = new Member2(MemberConst.EMAIL, MemberConst.NICKNAME, MemberConst.PHONE);
        System.out.println(">>> m3: " + m3);
    }
}

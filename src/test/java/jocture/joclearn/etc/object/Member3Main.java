package jocture.joclearn.etc.object;

public class Member3Main {

    static void main() {
        Member3 m1 = Member3.withAll(MemberConst.EMAIL, MemberConst.NICKNAME, MemberConst.PHONE, MemberConst.ADDRESS);
        System.out.println(">>> m1: " + m1);

        Member3 m2 = Member3.withBasic(MemberConst.EMAIL, MemberConst.NICKNAME);
        System.out.println(">>> m2: " + m2);

        Member3 m3 = Member3.withBasicAndPhone(MemberConst.EMAIL, MemberConst.NICKNAME, MemberConst.PHONE);
        System.out.println(">>> m3: " + m3);

        Member3 m4 = Member3.withBasicAndAddress(MemberConst.EMAIL, MemberConst.NICKNAME, MemberConst.ADDRESS);
        System.out.println(">>> m4: " + m4);
    }
}

package jocture.joclearn.etc.object;

public class Member6Main {

    static void main() {
        Member6 m1 = Member6.withBasic(MemberConst.EMAIL, MemberConst.NICKNAME)
            .phone(MemberConst.PHONE)
            .address(MemberConst.ADDRESS)
            .build();
        System.out.println(">>> m1: " + m1);

        Member6 m2 = Member6.withBasic(MemberConst.EMAIL, MemberConst.NICKNAME)
            .build();
        System.out.println(">>> m2: " + m2);
    }
}

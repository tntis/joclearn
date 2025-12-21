package jocture.joclearn.application.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jocture.joclearn.application.member.data.dto.MemberJoinRequest;
import jocture.joclearn.domain.common.exception.NotFoundException;
import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.MemberRepository;
import jocture.joclearn.domain.member.PasswordEncoder;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements MemberReader, MemberWriter {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public void getMembers() {

    }

    @Override
    public Member getMember(int memberId) {
        return memberRepository.findById(memberId)
            .orElseThrow(() -> new NotFoundException("회원을 찾을 수 없습니다.:" + memberId));
    }

    @Override
    @Transactional
    public Member joinMember(MemberJoinRequest request) {
        Member member = request.toEntity(passwordEncoder);
        System.out.println("save() 호출 전");
        Member savedMember = memberRepository.save(member);
        System.out.println("save() 호출 후");
        return savedMember;
    }

    @Override
    @Transactional
    public void updateMember() {

    }

    @Override
    @Transactional
    public void leaveMember() {

    }
}

package jocture.joclearn.application.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService implements MemberWriter, MemberReader {

    @Override
    public void getMembers() {

    }

    @Override
    public void getMember() {

    }

    @Override
    @Transactional
    public void joinMember() {

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

package org.sopt.controller;

import org.sopt.domain.Member;
import org.sopt.service.MemberServiceimpl;

import java.util.List;
import java.util.Optional;

public class MemberController {

    private MemberServiceimpl memberServiceimpl = new MemberServiceimpl();

    public Long createMember(String name) {

        return memberServiceimpl.join(name);
    }

    public Optional<Member> findMemberById(Long id) {
        return memberServiceimpl.findOne(id);
    }

    public List<Member> getAllMembers() {
        return memberServiceimpl.findAllMembers();
    }
}

package org.sopt.controller;

import org.sopt.domain.Gender;
import org.sopt.domain.Member;
import org.sopt.service.MemberServiceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MemberController {

    private MemberServiceimpl memberServiceimpl = new MemberServiceimpl();

    public Long createMember(String name, LocalDate birth, String email, Gender gender) {

        return memberServiceimpl.join(name, birth, email, gender);
    }

    public Optional<Member> findMemberById(Long id) {
        return memberServiceimpl.findOne(id);
    }

    public List<Member> getAllMembers() {
        return memberServiceimpl.findAllMembers();
    }

    public Optional<Member> findMemberByEmail(String email) {
        return memberServiceimpl.findByEmail(email);
    }
}

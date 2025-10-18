package org.sopt.controller;

import org.sopt.domain.Gender;
import org.sopt.domain.Member;
import org.sopt.service.MemberService;
import org.sopt.service.MemberServiceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MemberController {

    //private MemberServiceimpl memberServiceimpl = new MemberServiceimpl();
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public Long createMember(String name, LocalDate birth, String email, Gender gender) {

        return memberService.join(name, birth, email, gender);
    }

    public Optional<Member> findMemberById(Long id) {
        return memberService.findOne(id);
    }

    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }

    public Optional<Member> findMemberByEmail(String email) {
        return memberService.findByEmail(email);
    }

    public void deleteMember(Long id) {
        memberService.deleteMember(id);
    }

    public void validateAge(LocalDate birth) {
        memberService.validateAge(birth);
    }
}

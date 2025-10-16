package org.sopt.service;

import org.sopt.domain.Gender;
import org.sopt.domain.Member;
import org.sopt.repository.MemberRepository;
import org.sopt.repository.MemoryMemberRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

public class MemberServiceimpl implements MemberService {

    //private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    //private final MemoryMemberRepository memberRepository;
    private final MemberRepository  memberRepository;
    private static long sequence = 1L;

    public MemberServiceimpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(String name, LocalDate birth, String email, Gender gender) {
        validateAge(birth);
        vaildateDuplication(email);

        Member member = new Member(sequence++, name, birth, email, gender);
        memberRepository.save(member);
        return member.getId();
    }

    public void validateAge(LocalDate birth) {
        LocalDate today = LocalDate.now();
        int age = Period.between(birth, today).getYears();
        if(age < 20) {
            throw new IllegalArgumentException("⚠️ 20세 미만은 가입이 불가능합니다.");
        }
    }

    private void vaildateDuplication(String email) {
        memberRepository.findByEmail(email)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
                });
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public void deleteMember(Long memberId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 회원을 찾을 수 없습니다."));
        memberRepository.deleteById(memberId);
    }
}

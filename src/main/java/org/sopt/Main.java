package org.sopt;

import org.sopt.application.MemberApplication;
import org.sopt.controller.MemberController;
import org.sopt.repository.MemoryMemberRepository;
import org.sopt.service.MemberService;
import org.sopt.service.MemberServiceimpl;
import org.sopt.view.InputView;
import org.sopt.view.OutputView;

public class Main {
    public static void main(String[] args) {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MemberServiceimpl(memberRepository);
        MemberController memberController = new MemberController(memberService);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();


        MemberApplication application = new MemberApplication(inputView, outputView, memberController);
        application.run();
    }
}
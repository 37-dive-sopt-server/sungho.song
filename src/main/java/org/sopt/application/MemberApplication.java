package org.sopt.application;

import org.sopt.controller.MemberController;
import org.sopt.domain.Gender;
import org.sopt.domain.Member;
import org.sopt.view.InputView;
import org.sopt.view.OutputView;

import java.time.LocalDate;
import java.util.Optional;

public class MemberApplication {

    private final InputView inputView;
    private final OutputView outputView;
    private final MemberController memberController;

    public MemberApplication(InputView inputView, OutputView outputView, MemberController memberController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.memberController = memberController;
    }

    public void run() {
        while (true) {
            outputView.outputMenu();
            String choice = inputView.inputMenuNumber();

            try {
                route(choice);
            } catch (IllegalStateException | IllegalArgumentException e) {
                outputView.outputError(e.getMessage());
            }
        }
    }

    private void route(String choice) {
        switch (choice) {
            case "1" -> registerMember();
            case "2" -> findMemberById();
            case "3" -> findAllMembers();
            case "4" -> deleteMember();
            case "5" -> {
                outputView.outputMessage("👋 서비스를 종료합니다. 안녕히 계세요!");
                System.exit(0);
            }
            default -> outputView.outputError("\uD83D\uDEAB 잘못된 메뉴 선택입니다. 다시 시도해주세요.");
        }
    }

    private void registerMember() {
        String name = inputView.inputName();
        LocalDate birth = inputView.inputBirth();
        String email = inputView.inputEmail();
        Gender gender = inputView.inputGender();

        Long createdId = memberController.createMember(name, birth, email, gender);
        outputView.outputMessage("✅ 회원 등록 완료 (ID: " + createdId + ")");
    }

    private void findMemberById() {
        Long id = inputView.inputMemberId("조회할 회원 ID를 입력하세요: ");
        Optional<Member> foundMember = memberController.findMemberById(id);
        if (foundMember.isPresent()) {
            outputView.outputMemberDetails(foundMember.get());
        } else {
            outputView.outputMessage("⚠️ 해당 ID의 회원을 찾을 수 없습니다.");
        }
    }

    private void findAllMembers() {
        outputView.outputAllMembers(memberController.getAllMembers());
    }

    private void deleteMember() {
        Long idToDelete = inputView.inputMemberId("삭제할 회원 ID를 입력하세요: ");
        memberController.deleteMember(idToDelete);
        outputView.outputMessage("✅ ID " + idToDelete + "번 회원이 삭제되었습니다.");
    }
}
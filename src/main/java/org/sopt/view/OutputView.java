package org.sopt.view;

import org.sopt.domain.Member;
import java.util.List;

public class OutputView {

    public void displayMenu() {
        System.out.println("\n✨ --- DIVE SOPT 회원 관리 서비스 --- ✨");
        System.out.println("---------------------------------");
        System.out.println("1️⃣. 회원 등록 ➕");
        System.out.println("2️⃣. ID로 회원 조회 🔍");
        System.out.println("3️⃣. 전체 회원 조회 📋");
        System.out.println("4️⃣. 회원 삭제 🔥");
        System.out.println("5️⃣. 종료 🚪");
        System.out.println("---------------------------------");
        System.out.print("메뉴를 선택하세요: ");
    }

    public void displayMemberDetails(Member member) {
        System.out.println("✅ 조회된 회원");
        System.out.println("ID: " + member.getId());
        System.out.println("이름: " + member.getName());
        System.out.println("이메일: " + member.getEmail());
        System.out.println("생년월일: " + member.getBirth());
        System.out.println("성별: " + member.getGender());
    }

    public void displayAllMembers(List<Member> allMembers) {
        if (allMembers.isEmpty()) {
            System.out.println("ℹ️ 등록된 회원이 없습니다.");
            return;
        }
        System.out.println("--- 📋 전체 회원 목록 📋 ---");
        for (Member member : allMembers) {
            System.out.println("👤 ID=" + member.getId() + "" +
                    ", 이름=" + member.getName() + "" +
                    ", 생년월일=" + member.getBirth() + "" +
                    ", email=" + member.getEmail() + "" +
                    ", 성별=" + member.getGender() + ""
            );
        }
        System.out.println("--------------------------");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String errorMessage) {
        System.out.println("❌ " + errorMessage);
    }
}
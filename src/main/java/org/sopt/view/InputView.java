package org.sopt.view;

import org.sopt.domain.Gender;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String inputMenuNumber() {
        return scanner.nextLine();
    }

    public String inputName() {
        System.out.print("이름: ");
        return scanner.nextLine();
    }

    public LocalDate inputBirth() {
        while (true) {
            try {
                System.out.print("생년월일 (YYYY-MM-DD): ");
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("❌ 날짜 형식이 올바르지 않습니다. (YYYY-MM-DD)");
            }
        }
    }

    public String inputEmail() {
        System.out.print("이메일: ");
        return scanner.nextLine();
    }

    public Gender inputGender() {
        while (true) {
            try {
                System.out.print("성별 (MALE/FEMALE): ");
                return Gender.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("❌ 성별을 MALE 또는 FEMALE로 정확히 입력해주세요.");
            }
        }
    }

    public Long inputMemberId(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ 유효하지 않은 ID 형식입니다. 숫자를 입력해주세요.");
            }
        }
    }
}
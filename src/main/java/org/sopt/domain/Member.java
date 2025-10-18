package org.sopt.domain;

import java.time.LocalDate;

public class Member {

    private Long id;
    private String name;
    private LocalDate birth;
    private String email;
    private Gender gender;

    public Member(Long id, String name, LocalDate birth, String email, Gender gender) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }
}

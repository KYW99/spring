package com.ch07.entity;

import com.ch07.dto.User5DTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user5")
public class User5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 필드(컬럼) 값이 자동 1 증가(auto_increment)
    private int seq;

    private String name;
    private String gender;
    private int age;
    private String addr;

    public User5DTO toDTO(){

        return User5DTO.builder()
                .seq(seq)
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();
    }
}

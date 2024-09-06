package com.ch06.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User4DTO {

    private String uid;
    private String name;
    private String gender;
    private int age;
    private String hp;
    private String addr;


}

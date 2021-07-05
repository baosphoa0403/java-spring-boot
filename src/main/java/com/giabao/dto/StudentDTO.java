package com.giabao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {
    private int id;

    private String name;

    private int age;

    private String yob;

    private String email;

    private String roleID;
}

package com.giabao.dto;

import com.giabao.entity.RoleEntity;
import com.giabao.entity.StatusEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    private Set<RoleEntity> listRole;

    private StatusEntity status;
}

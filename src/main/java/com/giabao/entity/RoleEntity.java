package com.giabao.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giabao.entity.StudentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;
    @Column(name = "roleName")
    private String roleName;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<StudentEntity> listStudentEntity = new HashSet<>();

}

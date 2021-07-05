package com.giabao.entity;
import com.giabao.entity.StudentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

//    @OneToMany(mappedBy = "role")
//    private Collection<Student> listStudent;
    @ManyToMany(mappedBy = "roles")
    private List<StudentEntity> listStudentEntity = new ArrayList<>();

}

package com.giabao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "yob")
    private String yob;
    @Column(name = "email")
    private String email;

    @Column(name = "roleID")
    private String roleID;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", yob='" + yob + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @ManyToMany
    @JoinTable(name = "role_student",
            joinColumns = @JoinColumn(name = "role"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<RoleEntity> roles = new ArrayList<>();
//    @ManyToOne
//    @JoinColumn(name = "roleid")
//    private RoleDTO role;
}

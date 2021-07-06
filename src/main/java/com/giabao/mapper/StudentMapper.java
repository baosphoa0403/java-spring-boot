package com.giabao.mapper;

import com.giabao.dto.StudentDTO;
import com.giabao.entity.StudentEntity;


public class StudentMapper {
    public StudentDTO convertToStudentDTO(StudentEntity s){
        return new StudentDTO(s.getId(), s.getName(), s.getAge(), s.getYob(), s.getEmail(), s.getRoles(), s.getStatus());
    }


}

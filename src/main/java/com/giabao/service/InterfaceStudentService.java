package com.giabao.service;

import com.giabao.Interface.IGeneralService;
import com.giabao.dto.StudentDTO;
import com.giabao.entity.StudentEntity;

import java.util.List;

public interface InterfaceStudentService extends IGeneralService<StudentDTO> {
    public List<StudentDTO> getAll();

    public StudentDTO updateStudent(int studentID, int roleID);
}

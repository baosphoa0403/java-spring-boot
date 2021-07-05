package com.giabao.service;

import com.giabao.Errors.StudentNotFoundException;
import com.giabao.dto.StudentDTO;
import com.giabao.mapper.StudentMapper;
import com.giabao.repository.InterfaceStudentRepository;
import com.giabao.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImp implements InterfaceStudentService {

    @Autowired
    private InterfaceStudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAll() {
        ArrayList<StudentDTO> listStudentDTO = new ArrayList<>();
        StudentMapper mapper = new StudentMapper();
        for (StudentEntity s: studentRepository.findAll()){
            listStudentDTO.add(mapper.convertToStudentDTO(s));
        }
        return listStudentDTO;
    }

    @Override
    public Iterable<StudentDTO> findAll() {
        ArrayList<StudentDTO> listStudentDTO = new ArrayList<>();
        StudentMapper mapper = new StudentMapper();
        for (StudentEntity s: studentRepository.findAll()){
            listStudentDTO.add(mapper.convertToStudentDTO(s));
        }
        return listStudentDTO;
    }

    @Override
    public StudentDTO findById(Integer id)  {
       try {
           StudentEntity s = studentRepository.getById(id);
           StudentMapper mapper = new StudentMapper();
           StudentDTO dto = mapper.convertToStudentDTO(s);
           return dto;
       }catch (EntityNotFoundException ex) {
           throw new EntityNotFoundException("student not found with " + id);
       }
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }


}

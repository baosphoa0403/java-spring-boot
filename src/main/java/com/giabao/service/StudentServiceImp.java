package com.giabao.service;

import com.giabao.Errors.StudentNotFoundException;
import com.giabao.dto.RoleDTO;
import com.giabao.dto.StatusDTO;
import com.giabao.dto.StudentDTO;
import com.giabao.entity.RoleEntity;
import com.giabao.entity.StatusEntity;
import com.giabao.mapper.StudentMapper;
import com.giabao.repository.InterfaceRoleReqository;
import com.giabao.repository.InterfaceStatusReqository;
import com.giabao.repository.InterfaceStudentRepository;
import com.giabao.entity.StudentEntity;
import com.giabao.util.MyContants;
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
    @Autowired
    private InterfaceRoleReqository roleRepository;
    @Autowired
    private  InterfaceStatusService statusService;

    @Override
    public List<StudentDTO> getAll() {
        ArrayList<StudentDTO> listStudentDTO = new ArrayList<>();
        StudentMapper mapper = new StudentMapper();
        System.out.println(studentRepository.findAll());
        for (StudentEntity s: studentRepository.findAll()){
             listStudentDTO.add(mapper.convertToStudentDTO(s));
        }
        return listStudentDTO;
    }

    @Override
    public StudentDTO updateStudent(int studentID, int roleID) {
        StudentEntity s = studentRepository.findById(studentID).get();
        RoleEntity r = roleRepository.findById(roleID).get();
        s.getRoles().add(r);
        this.studentRepository.save(s);
        StudentMapper mapper = new StudentMapper();
        return mapper.convertToStudentDTO(s);
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
        StatusDTO status = this.statusService.findById(MyContants.STATUS_ID_ACTIVE);
        StudentEntity entity = new StudentEntity(studentDTO.getId(),studentDTO.getName(),
                studentDTO.getAge(),studentDTO.getYob(),studentDTO.getEmail(), studentDTO.getListRole(), new StatusEntity(status.getStatusID(), status.getStatusName(), null));
        StudentMapper mapper = new StudentMapper();
        return mapper.convertToStudentDTO(this.studentRepository.save(entity));
    }

    @Override
    public void remove(Integer id) {
        this.studentRepository.deleteById(id);
    }


}

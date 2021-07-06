package com.giabao.APIController;


import com.giabao.Errors.StudentNotFoundException;
import com.giabao.dto.StudentDTO;
import com.giabao.entity.StudentEntity;
import com.giabao.mapper.StudentMapper;
import com.giabao.service.InterfaceStudentService;
import com.giabao.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
    @Autowired
    private InterfaceStudentService studentServiceImp;

    @GetMapping
    public Iterable<StudentDTO> getAllStudent() {
        return studentServiceImp.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentByID(@PathVariable(value = "id") Integer id) {
        StudentDTO a = this.studentServiceImp.findById(id);
        return ResponseEntity.ok(a);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO student){
        return this.studentServiceImp.save(student);
    }

    @PutMapping("/{idStudent}/role/{idRole}")
    public StudentDTO updateStudent(@PathVariable (value = "idStudent") Integer idStudent, @PathVariable (value = "idRole") Integer idRole){
        return this.studentServiceImp.updateStudent(idStudent, idRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable (value = "id") Integer id){
        System.out.println(id);
        this.studentServiceImp.remove(id);
        return ResponseEntity.ok("remove successfull " + id);
    }

}

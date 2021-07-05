package com.giabao.APIController;


import com.giabao.Errors.StudentNotFoundException;
import com.giabao.dto.StudentDTO;
import com.giabao.entity.StudentEntity;
import com.giabao.mapper.StudentMapper;
import com.giabao.service.InterfaceStudentService;
import com.giabao.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> getStudentByID(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        StudentDTO a = this.studentServiceImp.findById(id);
        return ResponseEntity.ok(a);
    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    public Student createStudent(@RequestBody Student student){
//        return this.studentService.save(student);
//    }
//
//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable (value = "id") Integer id, @RequestBody Student student){
//        Student studentExist =  this.studentService.findById(id).orElseThrow(() ->
//                        new StudentNotFoundException("student not found" + id));
//        studentExist.setAge(student.getAge());
//        studentExist.setEmail(student.getEmail());
//        studentExist.setYob(student.getYob());
//        studentExist.setName(student.getName());
//        return this.studentService.save(studentExist);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Student> deleteStudent(@PathVariable (value = "id") Integer id){
//        Student studentExist =  this.studentService.findById(id).orElseThrow(() ->
//                new StudentNotFoundException("student not found" + id));
//        this.studentService.remove(id);
//        return ResponseEntity.ok().build();
//    }

}

package com.giabao.repository;

import com.giabao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceStudentRepository extends JpaRepository<StudentEntity, Integer> {

}

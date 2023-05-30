package com.example.demo.Repositry;

import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryStudent extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);
    Student findStudentByName(String name);
    List<Student> findStudentByCoursesId(Integer id);
}

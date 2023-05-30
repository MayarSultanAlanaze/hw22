package com.example.demo.Controller;


import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.Model.Student;
import com.example.demo.Model.Teacher;
import com.example.demo.Service.ServiceStudent;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class ControllerStudent {
    private final ServiceStudent serviceStudent;

    @GetMapping("/get/")
    public ResponseEntity getAllStudent() {
        List<Student> student = serviceStudent.getAllStudent();
        return ResponseEntity.status(200).body(student);
    }


    @PostMapping("/add/")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        serviceStudent.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, @PathVariable Integer id) {
        serviceStudent.updateStudent(student, id);
        return ResponseEntity.status(200).body("Student Updated");
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        serviceStudent.DeleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted");
    }

    @PutMapping("/{Student_id}/assign/{course_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer Student_id, @PathVariable Integer course_id) {
       serviceStudent.assignTeacherToCourse(Student_id,course_id );
        return ResponseEntity.status(200).body("Assign done");
    }
    @PutMapping("/update-major/{id}")
    public ResponseEntity updateMajor(@Valid @RequestBody Student student,@PathVariable Integer id){
        serviceStudent.updateMajor(student, id);
        return ResponseEntity.status(200).body("student update");
    }
    public ResponseEntity studentList(@PathVariable Integer id){
        List<Student>students=serviceStudent.studentList(id);
        return ResponseEntity.status(200).body("student");
    }

}

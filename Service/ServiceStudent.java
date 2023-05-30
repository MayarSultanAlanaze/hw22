package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.Model.Course;
import com.example.demo.Model.Student;
import com.example.demo.Model.Teacher;
import com.example.demo.Repositry.RepositoryCourse;
import com.example.demo.Repositry.RepositoryStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceStudent {
    private final RepositoryStudent repositoryStudent;
    private final RepositoryCourse repositoryCourse;
    public List<Student> getAllStudent() {
        return repositoryStudent.findAll();
    }
    public void addStudent
            (Student student) {
        repositoryStudent.save(student);
    }
    public void updateStudent(Student student,Integer id) {
        Student student1=repositoryStudent.findStudentById(student.getId());
        if (student1 == null) {
            throw new ApiException("not found");
        }
            student1.setName(student.getName());
            student1.setAge(student.getAge());
            student1.setMajor(student.getMajor());
            repositoryStudent.save(student1);
        }
        public void DeleteStudent(Integer id) {
        Student student = repositoryStudent.findStudentById(id);
        if (student == null) {
            throw new ApiException("not found");
        }
        repositoryStudent.delete(student);
    }
        public void assignTeacherToCourse(Integer student_id,Integer course_id) {
        Student student = repositoryStudent.findStudentById(student_id);
         Course course=repositoryCourse.findCourseById(course_id);
        if (student == null||course==null) {
            throw new ApiException("not found");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        repositoryCourse.save(course);
        repositoryStudent.save(student);
        //student.setMajor(student_major);
        //student.setCourses(null);
       // repositoryStudent.save(student);
    }
        public void updateMajor(Student student,Integer id){
        Student student1=repositoryStudent.findStudentById(id);

            // Course course=repositoryCourse.findCourseById(id);
        if (student1==null){
            throw new ApiException("not found");
        }
       // student1.setMajor(student.getMajor());
      //  student1.getCourses().remove(student1.getCourses());
      //  repositoryStudent.save(student1);

      // course.setId(id);
       // course.getStudents();
        //repositoryCourse.save(course);
    }

    public List<Student> studentList(Integer course_id){
        Course course=repositoryCourse.findCourseById(course_id);
        List<Student>students=repositoryStudent.findStudentByCoursesId(course_id);
        return students;

    }

}

package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.Model.Course;
import com.example.demo.Model.Teacher;
import com.example.demo.Repositry.RepositoryCourse;
import com.example.demo.Repositry.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceCourse {
    private final RepositoryCourse repositoryCourse;
   private  final TeacherRepository teacherRepository;

    public void addDetails(Course course) {
        Teacher teacher=teacherRepository.findTeacherById(course.getId());
        Course course1=repositoryCourse.findCourseById(course.getId());
        if (teacher==null){
            throw new ApiException("not found");
        }
        repositoryCourse.save(course);
    }

    public void updateCourse(Course dto) {
       Course course=repositoryCourse.findCourseById(dto.getId());
        if (course == null) {
            throw new ApiException("not found");
        }
        course.setName(course.getName());
        repositoryCourse.save(course);

    }

    public void deleteCourse(Integer id){
        Course course=repositoryCourse.findCourseById(id);
        if (course==null){
            throw  new ApiException("not found");
        }
        repositoryCourse.save(course);

    }
    public void assignTeacherToCourse(Integer teacher_id,String Course_name){
        Teacher teacher=teacherRepository.findTeacherById(teacher_id);
        Course course=repositoryCourse.getCourseByName(Course_name);
        if (teacher==null || course==null){
            throw new ApiException("not found");
        }
        course.setTeacher(teacher);
        repositoryCourse.save(course);
    }
}

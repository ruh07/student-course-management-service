package com.garg.academic.controllers;

import com.garg.academic.domian.Course;
import com.garg.academic.services.CourseService;
import com.garg.academic.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Courses")
public class CourseController {

    @Autowired
    private final StudentService studentService;

    @Autowired
    private final CourseService courseService;


    @GetMapping("/AllCourses")
    public List<Course> getAllCourse() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
       return courseService.getCourseById(id);
    }

    @PostMapping("/SaveCourse")
    public String saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return "Course Saved successfully!!!";
    }

    @PostMapping("/RegisterForCourse/Student/{studentId}/Course/{courseId}")
    public String registerStudentForCourse (
            @PathVariable Long studentId,
            @PathVariable Long courseId ) {
        var student = studentService.findStudent(studentId);
        var course = courseService.getCourseById(courseId);
        if (student != null && course != null) {
            var courses = student.getCourses();
            courses.add(course);
            student.setCourses(courses);
            studentService.createStudent(student);
        } else {
            throw new RuntimeException("Invalid Student Or Course ID");
        }

        return "Student Registered!!!";
    }

}

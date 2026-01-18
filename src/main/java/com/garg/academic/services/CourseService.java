package com.garg.academic.services;

import com.garg.academic.domian.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    void saveCourse(Course course);

    Course getCourseById(Long id);
}

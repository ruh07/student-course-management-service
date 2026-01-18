package com.garg.academic.services.impl;

import com.garg.academic.domian.Course;
import com.garg.academic.repositories.CourseRepository;
import com.garg.academic.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCourse(Course course){
        courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
}

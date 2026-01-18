package com.garg.academic.services;

import com.garg.academic.domian.Student;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentService {

    List<Student> all();

    Student createStudent(Student input);

    Student findStudent(Long id);

    List<Student> getStudents(Long id, String studentName);

    Student updateStudentDomain(Student userInput, Long id);

    void deleteStudent(Long id);

    List<Student> getStudentByDate(LocalDateTime enrollDate, Boolean activeEnrollment);
}

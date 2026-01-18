package com.garg.academic.services;

import com.garg.academic.domian.Assignment;
import com.garg.academic.domian.Student;

import java.util.List;

public interface AssignmentService {

    Student createStudentAndTasks(Student input);

    String setTaskForStudent(Long id, String task);

    List<Assignment> findByStudentId(Long studentId);

    List<Assignment> all();
}

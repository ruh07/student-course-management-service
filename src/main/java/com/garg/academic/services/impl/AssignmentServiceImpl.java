package com.garg.academic.services.impl;

import com.garg.academic.domian.Assignment;
import com.garg.academic.domian.Student;
import com.garg.academic.repositories.AssignmentRepository;
import com.garg.academic.repositories.StudentRepository;
import com.garg.academic.services.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    @Transactional
    public Student createStudentAndTasks(Student input) {
        for (Assignment assignmentIn: input.getAssignments()) {
            assignmentIn.setStudent(input);
        }

        var studentOut = studentRepository.save(input);
        return studentOut;
    }

    @Override
    public String setTaskForStudent(Long id, String task) {
        var studentTemp = studentRepository.getById(id);

        var assignments = studentTemp.getAssignments();

        var newAssignment = new Assignment(task);

        newAssignment.setStudent(studentTemp);
        assignments.add(newAssignment);
        studentRepository.save(studentTemp);
        return "Task Saved Successfully!!!!";
    }

    @Override
    public List<Assignment> findByStudentId(Long studentId) {
        return assignmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Assignment> all() {
        return assignmentRepository.findAll();
    }
}

package com.garg.academic.services.impl;

import com.garg.academic.domian.Student;
import com.garg.academic.domian.exception.StudentNotFoundException;
import com.garg.academic.repositories.StudentRepository;
import com.garg.academic.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Qualifier("StudentServie")
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> all() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student createStudent(Student input) {
        return studentRepository.save(input);
    }

    @Override
    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public List<Student> getStudents(Long id, String studentName) {
        return studentRepository.findByIdAndName(id, studentName);
    }

    @Override
    @Transactional
    public Student updateStudentDomain(Student userInput, Long id) {
        return studentRepository.findById(id)
                .map(found -> {
                    found.setStudentEmail(userInput.getStudentEmail());
                    found.setStudentName(userInput.getStudentName());
                    found.setEnrollDate(userInput.getEnrollDate());
                    found.setActiveEnrollment(userInput.getActiveEnrollment());
                    return studentRepository.save(found);
                })
                .orElseGet(() -> {
                    userInput.setId(id);
                    return studentRepository.save(userInput);
                });
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentByDate(LocalDateTime enrollDate, Boolean activeEnrollment) {
        return studentRepository.findByActiveEnrollment(enrollDate, activeEnrollment);
    }
}

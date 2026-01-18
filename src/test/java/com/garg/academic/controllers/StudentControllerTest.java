package com.garg.academic.controllers;

import com.garg.academic.domian.Student;
import com.garg.academic.services.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentControllerTest {

    @Mock
    private StudentService service;
    @InjectMocks
    private StudentController controller;

    @Test
    public void allStudentsTest() {
        //Arrange
        List<Student> mockStudents = createMockStudents();
        when(service.all()).thenReturn(mockStudents);
        //Act
        List<Student> students = controller.all();
        //Assert
        assertEquals(mockStudents, students);
    }

    @Test
    public void findStudentTest() {
        Long studentId = 1L;
        Student mockStudent = createMockStudent(studentId);
        when(service.findStudent(studentId)).thenReturn(mockStudent);
        Student student = controller.getStudentById(studentId);
        assertEquals(mockStudent, student);
    }
    @Test
    public void registerNewStudentTest() {
        Student studentToRegister = createMockStudent(null);
        Student createdStudent = createMockStudent(2L);
        when(service.createStudent(studentToRegister)).thenReturn(createdStudent);
        ResponseEntity<Student> response = controller.registerNewStudent(studentToRegister);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdStudent, response.getBody());
    }
    // Helper method to create mock Student objects
    private List<Student> createMockStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "John Doe", "john.doe@example.com", LocalDateTime.now(), true, null, null));
        students.add(new Student(2L, "Jane Smith", "jane.smith@example.com", LocalDateTime.now().minusDays(10), false, null, null));
// Add more students as needed for your tests
        return students;
    }
    private Student createMockStudent(Long id) {
        return new Student(id, "New Student", "new.student@example.com", LocalDateTime.now(), true, null, null);
    }
}



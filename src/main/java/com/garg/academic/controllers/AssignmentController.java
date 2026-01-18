package com.garg.academic.controllers;

import com.garg.academic.domian.Assignment;
import com.garg.academic.domian.Student;
import com.garg.academic.domian.dto.AssignmentsDto;
import com.garg.academic.domian.dto.StudentDto;
import com.garg.academic.services.AssignmentService;
import com.garg.academic.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Assignment")
public class AssignmentController {

    private final StudentService studentService;
    private final AssignmentService assignmentService;

    @PostMapping("/SaveStudentAndAssignment")
    public String saveStudentAndAssignment(@RequestBody Student student) {
        var createStudent = assignmentService.createStudentAndTasks(student);
        return "Student And Assignment Saved Successfully!!!";
    }

    @PostMapping("/SetAssignmentForStudent")
    public String setAssignmentForStudent(@RequestParam(name = "id")String id, @RequestParam String task){
        return assignmentService.setTaskForStudent(Long.valueOf(id), task);
    }

    @GetMapping("/AllStudentsWithAssignments")
    public ResponseEntity<List<StudentDto>> getAllStudentsWithAssignments() {
        var students  = studentService.all();
        List<StudentDto> studentDtos = new ArrayList<>();

        for (Student student: students) {
            var assignments = assignmentService.findByStudentId(student.getId());
            studentDtos.add(new StudentDto(student, assignments));
        }

        return ResponseEntity.ok(studentDtos);
    }

    @GetMapping("/AllAssignmentsWithStudents")
    public ResponseEntity<List<AssignmentsDto>> getAllAssignmentsWithStudents() {
        var assignments = assignmentService.all();
        List<AssignmentsDto> assignmentsDtos = new ArrayList<>();

        for (Assignment assignment: assignments) {
            var student = assignment.getStudent();
            assignmentsDtos.add(new AssignmentsDto(assignment, student));
        }
        return ResponseEntity.ok(assignmentsDtos);

    }
}

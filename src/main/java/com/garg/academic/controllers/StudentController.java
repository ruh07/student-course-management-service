package com.garg.academic.controllers;

import com.garg.academic.domian.Student;
import com.garg.academic.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
//@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    public StudentController(@Qualifier("StudentServie")StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/allstudents")
    public List<Student> all() {
        return studentService.all();
    }

    @PostMapping("/registerStudent")
    public ResponseEntity<Student> registerNewStudent(@RequestBody @Valid Student student) {
       var createStudent = studentService.createStudent(student);
       return ResponseEntity.status(HttpStatus.CREATED).body(createStudent);
    }

//    @PostMapping("/registerstudent")
//
//    public ResponseEntity<?> registerNewStudent(@RequestBody @Valid Student student, Errors errors) {
//
//        if (errors.hasErrors()) {
//
//            // get the error messages as a list of strings
//
//            List<String> errorMessages = errors.getAllErrors()
//
//                    .stream()
//
//                    .map(ObjectError::getDefaultMessage)
//
//                    .collect(Collectors.toList());
//
//            // return the list as the response body with 400 status code
//
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
//
//        }
//
//        Student createdStudent = studentService.createStudent(student);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
//
//    }

    @GetMapping("/findStudent/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findStudent(id);
    }

    @PutMapping("/upsertStrudent/{id}")
    Student upsert(@RequestBody Student input, @PathVariable Long id) {
        return studentService.updateStudentDomain(input, id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping(value = "/StudentSearchByIdOrName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getResource(@RequestParam Long id,
                                                     @RequestParam String studentName) {
        return new ResponseEntity<>
                (studentService.getStudents(
                    id,studentName),
                HttpStatus.OK);
    }

    @GetMapping(value = "/StudentsByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudentByDate(
            @RequestParam String enrollDate,
            @RequestParam Boolean activeEnrollment
    ) {
        return new ResponseEntity<>(studentService.getStudentByDate(
                LocalDateTime.parse(enrollDate),
                activeEnrollment), HttpStatus.OK);
    }

}

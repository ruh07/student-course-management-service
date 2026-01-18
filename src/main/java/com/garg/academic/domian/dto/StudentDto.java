package com.garg.academic.domian.dto;

import com.garg.academic.domian.Assignment;
import com.garg.academic.domian.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;
    private String studentName;
    private String studentEmail;
    private LocalDateTime enrollDate;
    private Boolean activeEnrollment;
    private List<Assignment> assignments;

    public StudentDto(Student student, List<Assignment> assignments) {
        this.id = student.getId();
        this.studentName = student.getStudentName();
        this.studentEmail = student.getStudentEmail();
        this.enrollDate = student.getEnrollDate();
        this.activeEnrollment = student.getActiveEnrollment();
        this.assignments = assignments;
    }

    public StudentDto(Student student) {
        this.id = student.getId();
        this.studentName = student.getStudentName();
        this.studentEmail = student.getStudentEmail();
        this.enrollDate = student.getEnrollDate();
        this.activeEnrollment = student.getActiveEnrollment();
    }
}

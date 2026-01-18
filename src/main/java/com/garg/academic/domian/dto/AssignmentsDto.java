package com.garg.academic.domian.dto;

import com.garg.academic.domian.Assignment;
import com.garg.academic.domian.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentsDto {
    private Long id;
    private String title;
    private StudentDto student;

    public AssignmentsDto(Assignment assignment, Student student) {
        this.id = assignment.getId();
        this.title = assignment.getTitle();
        this.student = new StudentDto(student);
    }
}

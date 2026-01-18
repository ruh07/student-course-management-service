package com.garg.academic.domian;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignment_details")
public class Assignment {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Long id;

    @Column(name = "title",unique = false, nullable = false, length = 1000)
    private String title;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    public Assignment(String title) {
        this.title = title;
    }

    @JsonBackReference
    public Student getStudent() {
        return student;
    }
}

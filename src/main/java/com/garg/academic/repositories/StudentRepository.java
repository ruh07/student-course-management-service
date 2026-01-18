package com.garg.academic.repositories;

import com.garg.academic.domian.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select st from Student st where st.id=?1 or st.studentName = ?2")
    List<Student> findByIdAndName(Long id, String studentName);

    @Query(value = "select st from Student st where st.enrollDate<=?1 or st.activeEnrollment = ?2")
    List<Student> findByActiveEnrollment(LocalDateTime enrollDate, Boolean activeEnrollment);
}
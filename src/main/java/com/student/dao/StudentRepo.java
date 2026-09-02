package com.student.dao;

import com.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    /// custom finder methods
    List<Student> findByNameContaining(String name);

    /// now we will find students based on the filter
    List<Student> findByBranch(String branch);

    /// filtering based on the year
    List<Student> findByYear(Integer year);

}

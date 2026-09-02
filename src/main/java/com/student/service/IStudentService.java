package com.student.service;

import com.student.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    public void addStudent(Student student);
    public List<Student> getAllStudent();
    public Optional<Student> getStudentById(Integer id);
    public void updateStudent(Student student);
    public void deleteStudentById(Integer id);

    /// Custom finder method
    public List<Student> fetchByName(String name);

    /// Adding filter
    List<Student> fetchByBranch(String branch);

    /// filtering based on the year
    List<Student> fetchByYear(Integer year);
    /// Pagination
    ///
    public Page<Student> fetchDetailsByPagination(int page, int pageSize);


}

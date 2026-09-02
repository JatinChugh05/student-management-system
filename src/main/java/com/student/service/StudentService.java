package com.student.service;

import com.student.dao.StudentRepo;
import com.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepo repo;

    @Override
    public void addStudent(Student student) {

        repo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public void updateStudent(Student student) {


        Optional<Student> optional = repo.findById(student.getId());
        if(optional.isPresent()) {
            repo.save(student);
        }
    }

    @Override
    public void deleteStudentById(Integer id) {

        Optional<Student> optional = repo.findById(id);
        if(optional.isPresent()) {
            repo.deleteById(id);
        }
    }

    /// Custom finder method
    @Override
    public List<Student> fetchByName(String name) {
        return repo.findByNameContaining(name);
    }

    /// Filter

    @Override
    public List<Student> fetchByBranch(String branch) {
        return repo.findByBranch(branch);
    }

    @Override
    public List<Student> fetchByYear(Integer year) {
        return repo.findByYear(year);
    }

    @Override
    public Page<Student> fetchDetailsByPagination(int page , int pageSize) {

        Pageable pageable =  PageRequest.of(page,pageSize);
        return repo.findAll(pageable);
    }
}


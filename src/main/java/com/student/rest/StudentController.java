package com.student.rest;


import com.student.model.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;



    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }


    /// user will get the form through it
    @GetMapping("/students/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

//    GET  /students/add
//     → SHOW the form
//
//    POST /students/add
//     → PROCESS the submitted form

    @PostMapping("/students/add")
    public String addStudent(Student student){

        service.addStudent(student);
        return "redirect:/students";
    }


//    @GetMapping("/students")
//    public String getALlStudent(Model model){
//
//        List<Student> studentList = service.getAllStudent();
//        model.addAttribute("list",studentList);
//        return "student-list";
//    }



    @GetMapping("/students/edit/{id}")
    public String getUpdateForm(@PathVariable Integer id, Model model){

        Optional<Student> optional = service.getStudentById(id);

        if(optional.isPresent()) {
            model.addAttribute("student", optional.get());
            return "update-student";
        }
        return "redirect:/students";
    }

    @PostMapping("/students/update")
    public String updateStudent(@ModelAttribute Student student){

        service.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudentById(@PathVariable Integer id){
        service.deleteStudentById(id);
        return "redirect:/students";
    }


    @GetMapping("/students/search")
    public String SearchByName(@RequestParam String name,Model model){

        List<Student> studentList = service.fetchByName(name);
        model.addAttribute("list",studentList);
        return "student-list";
    }

    /// filtering based on the branch
    @GetMapping("/students/filter/branch")
    public String filterByBranch(@RequestParam String branch,Model model){

        List<Student> filterList = service.fetchByBranch(branch);
        model.addAttribute("list",filterList);
        return "student-list";
    }

    /// filtering based on the year
    @GetMapping("/students/filter/year")
    public String filterByYear(@RequestParam Integer year,Model model){

        List<Student> filterList = service.fetchByYear(year);
        model.addAttribute("list",filterList);
        return "student-list";
    }

//    @GetMapping("/students")
//    public String SearchDetailsByPagination(@RequestParam int page , @RequestParam int pageSize, Model model) {
//
//        Page<Student> studentPage = service.fetchDetailsByPagination(page,pageSize);
//        model.addAttribute("page",studentPage);
//        model.addAttribute("list", studentPage.getContent());
//        return "student-list";
//    }

    @GetMapping("/students")
    public String getAllStudent(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int pageSize, Model model) {

        Page<Student> studentPage = service.fetchDetailsByPagination(page, pageSize);

        model.addAttribute("page", studentPage);
        model.addAttribute("list", studentPage.getContent());

        return "student-list";
    }
}

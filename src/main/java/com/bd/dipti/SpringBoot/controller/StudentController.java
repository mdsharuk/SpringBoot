package com.bd.dipti.SpringBoot.controller;

import com.bd.dipti.SpringBoot.Model.Student;
import com.bd.dipti.SpringBoot.Service.StudentNotFoundException;
import com.bd.dipti.SpringBoot.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

@GetMapping("/student")
    public String ShowAllStudent(Model model){
        List<Student>list=studentService.studentList();
        model.addAttribute("list",list);
        return "studentlist";
    }
    @GetMapping("/newstudent")
    public String newStudent(Model model){
    model.addAttribute("student",new Student());
    return "studentsave";
    }
    @PostMapping("/studentsave")
    public String studentsave(Student s){
    studentService.save(s);
    return "redirect:/student";
    }

    @GetMapping("/studentedit/{id}")
    public String StudentEdit(@PathVariable("id") Integer id,Model model){
        try {
            Student student =studentService.get(id);
            model.addAttribute("student",student);
            return "studentsave";
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/student";
    }
  @GetMapping("/studentdelete/{id}")
    public String deleteStudent(@PathVariable("id")Integer id){
        try {
            studentService.studentDelete(id);
            return "redirect:/student";
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }
      return "redirect:/student";
    }
}

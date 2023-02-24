package com.example.ATDev_aasignment_Students.Controllers;

import com.example.ATDev_aasignment_Students.Models.Student;
import com.example.ATDev_aasignment_Students.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    //CRUD operation --> APIs

    //add student to database
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        try{
            return studentService.addStudent(student);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    //get student from database through given id
    @GetMapping("/findById")
    public Student findByStudentId(@RequestParam("id") int id){
        return studentService.findByStudentId(id);
    }

    //get student from database through given email
    @GetMapping("/findByStudentEmail")
    public Student findByStudentEmail(@RequestParam("email") String email){
        return studentService.findByStudentEmail(email);
    }

    //get list of student from database through given name
    @GetMapping("/findByName")
    public List<Student> findByName(@RequestParam("name") String name){
        return studentService.findByName(name);
    }

    //get list of student from database through given state
    @GetMapping("/findByState")
    public List<Student> findByState(@RequestParam("state") String state){
        return studentService.findByState(state);
    }

    //get list of student from database through given range of age
    @GetMapping("/findByAge")
    public List<Student> findByAge(@RequestParam("age1") int age1, @RequestParam("age2") int age2){
        return studentService.findByAge(age1, age2);
    }

    //update student's mobile number in database through student id and new mobile number
    @PutMapping("/update")
    public String updateStudent(@RequestParam("id") int id,@RequestParam("mobileNo") String mobileNo){
        return studentService.updateStudent(id, mobileNo);
    }

    //delete student from database
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        return studentService.deleteStudent(id);
    }
}

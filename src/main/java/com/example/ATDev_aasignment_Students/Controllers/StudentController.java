package com.example.ATDev_aasignment_Students.Controllers;

import com.example.ATDev_aasignment_Students.Models.Student;
import com.example.ATDev_aasignment_Students.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        try{
            return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //get student from database through given id
    @GetMapping("/findById")
    public ResponseEntity<Student> findByStudentId(@RequestParam("id") int id){
        Student student = studentService.findByStudentId(id);
        if(student == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

       return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    //get student from database through given email
    @GetMapping("/findByStudentEmail")
    public ResponseEntity<Student> findByStudentEmail(@RequestParam("email") String email){
        Student student = studentService.findByStudentEmail(email);
        if(student == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    //get list of student from database through given name
    @GetMapping("/findByName")
    public ResponseEntity<List<Student>> findByName(@RequestParam("name") String name){
        List<Student> studentList = studentService.findByName(name);
        if(studentList == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(studentList, HttpStatus.FOUND);
    }

    //get list of student from database through given state
    @GetMapping("/findByState")
    public ResponseEntity<List<Student>> findByState(@RequestParam("state") String state){
        List<Student> studentList = studentService.findByState(state);
        if(studentList == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(studentList, HttpStatus.FOUND);
    }

    //get list of student from database through given range of age
    @GetMapping("/findByAge")
    public ResponseEntity<List<Student>> findByAge(@RequestParam("age1") int age1, @RequestParam("age2") int age2){
        List<Student> studentList = studentService.findByAge(age1, age2);
        if(studentList == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(studentList, HttpStatus.FOUND);
    }

    //update student's mobile number in database through student id and new mobile number
    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestParam("id") int id,@RequestParam("mobileNo") String mobileNo){
        try {
            return new ResponseEntity<>(studentService.updateStudent(id, mobileNo), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //delete student from database
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") int id){
        try {
            return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

package com.example.ATDev_aasignment_Students.Services;

import com.example.ATDev_aasignment_Students.Models.Student;
import com.example.ATDev_aasignment_Students.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) throws Exception{
        String email = student.getEmail();
//        if(!studentRepository.findByEmail(email))
//            throw new Exception("email already exists!!");

        studentRepository.save(student);
        return "student added successfully";
    }

    public Student findByStudentId(int id){
        return studentRepository.findById(id).get();
    }

    public Student findByStudentEmail(String email){
        return studentRepository.findByEmail(email);
    }

    public List<Student> findByName(String name){
        return studentRepository.findByName(name);
    }

    public List<Student> findByState(String state){
        return studentRepository.findByState(state);
    }

    public List<Student> findByAge(int age1, int age2){
        return studentRepository.findByAge(age1, age2);
    }

    public String updateStudent(int id, String mobileNo){
        Student student = studentRepository.findById(id).get();

        student.setMobileNo(mobileNo);
        studentRepository.save(student);

        return "mobile no updated successfully";
    }

    public String deleteStudent(int id){
        studentRepository.deleteById(id);
        return "deleted successfully";
    }
}

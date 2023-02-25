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

        Student oldStudent = studentRepository.findByEmail(email);
        if(oldStudent!=null)
            throw new Exception("email already exists. use another email!!");

        studentRepository.save(student);
        return "student added successfully";
    }

    public Student findByStudentId(int id){
        if(!studentRepository.findById(id).isPresent())
            return null;

        return studentRepository.findById(id).get();
    }

    public Student findByStudentEmail(String email){
        Student student = studentRepository.findByEmail(email);
        if (student == null)
            return null;

        return student;
    }

    public List<Student> findByName(String name){
        List<Student> studentList = studentRepository.findByName(name);
        if (studentList == null)
            return null;

        return studentList;
    }

    public List<Student> findByState(String state){
        List<Student> studentList = studentRepository.findByState(state);
        if (studentList == null)
            return null;

        return studentList;
    }

    public List<Student> findByAge(int age1, int age2){
        List<Student> studentList = studentRepository.findByAge(age1, age2);
        if (studentList == null)
            return null;

        return studentList;
    }

    public String updateStudent(int id, String mobileNo) throws Exception{
        if(!studentRepository.findById(id).isPresent())
            throw new Exception("wrong input id!!");

        Student student = studentRepository.findById(id).get();

        student.setMobileNo(mobileNo);
        studentRepository.save(student);

        return "mobile no updated successfully";
    }

    public String deleteStudent(int id) throws Exception{
        if(!studentRepository.findById(id).isPresent())
            throw new Exception("wrong input id!!");

        studentRepository.deleteById(id);
        return "deleted successfully";
    }
}

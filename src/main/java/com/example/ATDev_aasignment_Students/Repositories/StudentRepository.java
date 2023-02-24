package com.example.ATDev_aasignment_Students.Repositories;

import com.example.ATDev_aasignment_Students.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail(String email);
    List<Student> findByName(String name);
    List<Student> findByState(String state);

    @Query(value = "select * from atstudent where age>=:age1 and age<:age2", nativeQuery = true)
    List<Student> findByAge(int age1, int age2);
}

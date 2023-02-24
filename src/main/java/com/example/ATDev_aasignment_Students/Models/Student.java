package com.example.ATDev_aasignment_Students.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ATStudent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admissionNo;
    private String name;
    private int age;
    private String mobileNo;
    @Column(unique = true)
    private String email;
    private String state;
}

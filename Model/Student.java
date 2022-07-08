package com.bd.dipti.SpringBoot.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 30)
    private String name;
    @Column(nullable = false,length =30)
    private String email;
    @Column(nullable = false,length = 20)
    private String cell;
    @Column(nullable = false,length = 30)
    private String address;
    @Column(nullable = false,length = 20)
    private String gender;
    @Column(nullable = false,length = 20)
    private String subject;



}

package com.example.classchoolsp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Class {
    @Id
    private String classid;
    private String classname;
    private String classtime;
    private String manager;
    private String members;
    private String assignment;
    private String teachplace;
    private String studytime;
    private String classexplain;
    private String teachtype;
}

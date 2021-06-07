package com.example.classchoolsp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Assignment {
    @Id
    public String assignmentid;
    public String assignmentname;
    public String deadline;
    public String explain;
    public String classnum;
}

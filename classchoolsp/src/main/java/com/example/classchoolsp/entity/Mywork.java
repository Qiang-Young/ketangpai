package com.example.classchoolsp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Mywork {
    @Id
    public Integer userid;
    public String classnum;
    public String finish;
}

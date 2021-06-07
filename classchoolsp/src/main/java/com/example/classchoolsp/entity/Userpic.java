package com.example.classchoolsp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Userpic {
    public String picid;
    public String pic;
    public String userid;
    public String realpic;
}

package com.example.classchoolsp.controller;

import com.example.classchoolsp.entity.Assignment;
import com.example.classchoolsp.repository.AssignmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentHandler {

    @Autowired
    private AssignmentRespository assignmentRespository;

    @GetMapping("/findall")
    public List<Assignment> findAll(){
        return assignmentRespository.findAll();
    }
}

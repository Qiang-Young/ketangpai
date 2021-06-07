package com.example.classchoolsp.controller;

import com.example.classchoolsp.entity.Class;
import com.example.classchoolsp.entity.Users;
import com.example.classchoolsp.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassHandler {
    @Autowired
    private ClassRepository classRepository;


    @GetMapping("/findall")
    public List<Class> findAll(){
        return classRepository.findAll();
    }
    @GetMapping("/findById/{id}")
    public Class findById(@PathVariable("id") String id){
        return classRepository.findById(id).get();
    }

    @PostMapping("/save")
    public String save(@RequestBody Class cla){
        Class result = classRepository.save(cla);
        if(result != null){
            return "success";
        } else{
            return "error";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Class cla){
        Class result =  classRepository.save(cla);
        if(result != null){
            return "success";
        } else{
            return "error";
        }
    }
}

package com.example.classchoolsp.controller;

import com.example.classchoolsp.config.FastDFSUtils;
import com.example.classchoolsp.entity.Class;
import com.example.classchoolsp.entity.Mywork;
import com.example.classchoolsp.entity.Users;
import com.example.classchoolsp.repository.MyworkRepository;
import com.sun.deploy.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/mywork")
public class MyworkHandler {
    @Autowired
    private MyworkRepository myworkRepository;


    @GetMapping("/findall")
    public List<Mywork> findAll(){
        return myworkRepository.findAll();
    }
    @GetMapping("/findById/{id}")

    public Mywork findById(@PathVariable("id") String id){
        return myworkRepository.findById(id).get();
    }

    @PostMapping("/save")
    public String save(@RequestBody Mywork mywork){
        Mywork result = myworkRepository.save(mywork);
        if(result != null){
            return "success";
        } else{
            return "error";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Mywork mywork){
        Mywork result =  myworkRepository.save(mywork);
        if(result != null){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        myworkRepository.deleteById(id);
    }

    @PostMapping("/workfile")
    public String upworkfile(MultipartFile file, String id,Integer workindex){
        FastDFSUtils fastDFSUtils = new FastDFSUtils();
        String fileId = fastDFSUtils.upload(file);
        String url = "http://192.168.219.132/" + fileId;
        if(upthework(url,id,workindex) == 1){
            System.out.println("yes");
            return ("更新成功！！  url=" + url);
        }
        return ("更新失败！！");
    }


    public Integer upthework(String url,String id,Integer index){
        Mywork mywork = myworkRepository.findById(id).get();
        String work[] = mywork.workfile.split(",");
        System.out.println(work);
        work[index] = url;
        String swork = StringUtils.join(Arrays.asList(work), ",");
        System.out.println(swork);
        mywork.workfile = swork;
        Mywork result = myworkRepository.save(mywork);
        if(result != null){
            return 1;
        } else{
            return 0;
        }
    }
}

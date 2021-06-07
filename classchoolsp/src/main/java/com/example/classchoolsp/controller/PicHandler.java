package com.example.classchoolsp.controller;

//import com.example.classchoolsp.entity.Userpic;
//import com.example.classchoolsp.repository.UserpicRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@RequestMapping("/userpic")
//@RestController
//@CrossOrigin
public class PicHandler {
}
//    @Autowired
//    private UserpicRepository userpicRepository;
//
//    @PostMapping("/uploadPic")
//    public Userpic uploadFile(MultipartFile file, @RequestParam String userid, HttpServletRequest request) {
//        Userpic userpic = new Userpic();
//        if(userid.equals("null")){
//            userpic.setUserid(null);
//        } else {
//            userpic.setUserid(userid);
//        }
//        return userpicRepository.uploadFile(file, userpic,request);
//    }
//
//    @RequestMapping("/downloadPic")
//    public void downloadFile(@RequestParam String picid, HttpServletResponse response) {
//        userpicRepository.downloadFile(picid,response);
//    }
//
//    @RequestMapping("/deletePic")
//    public @ResponseBody String deleteFile(@RequestParam String picid) {
//        return userpicRepository.deleteFile(picid);
//    }
//
//}

package com.example.classchoolsp.controller;

import com.example.classchoolsp.config.FastDFSUtils;
import com.example.classchoolsp.entity.Users;
import com.example.classchoolsp.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.support.ResourceAdapterFactoryBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersHandler {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/findAll")
    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Users findById(@PathVariable("id") String id){ return usersRepository.findById(id).get();
    }


    @PostMapping("/save")
    public String save(@RequestBody Users users){
        Users result =  usersRepository.save(users);
        if(result != null){
            return "success";
        } else{
            return "error";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Users users){
        Users result =  usersRepository.save(users);
        if(result != null){
            return "success";
        } else{
            return "error";
        }
    }

    @PostMapping
    public Integer updateuserface(String url,String id){
        Users users = usersRepository.findById(id).get();
        users.setUserface(url);
        Users result = usersRepository.save(users);
        if(result != null){
            return 1;
        } else{
            return 0;
        }
    }

//    @RequestMapping("/upload")
//    @ResponseBody
//    public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws SerialException, SQLException {
//        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
//        if (!file.isEmpty()) {
//            String originName = file.getOriginalFilename();
//            if (!originName.endsWith("png") && !originName.endsWith("jpeg")) {
//                return "只能上传png或者jpeg文件";
//            }
//            String format = sdf.format(new Date());
//            String realPath = request.getServletContext().getRealPath("/") + format;
//            System.out.println(file.getName());
//            File saveFile = new File(config.getUploadFolder() + saveFileName);
//            System.out.println(saveFile.getAbsolutePath());
//            if (!saveFile.getParentFile().exists()) {
//                saveFile.getParentFile().mkdirs();
//            }
//            try {
//                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
//                out.write(file.getBytes());
//                out.flush();
//                out.close();
//                return "{\"url\":[\"" + config.getPreviewPath() + saveFile.getName() + "\"]}";
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                return "上传失败,";
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "上传失败,";
//            }
//        } else {
//            return "上传失败，因为文件为空.";
//        }
//    }

    @PostMapping("/userface")
    public String updateUserface(MultipartFile file,String id){
        FastDFSUtils fastDFSUtils = new FastDFSUtils();
        String fileId = fastDFSUtils.upload(file);
        String url = "http://192.168.219.131/" + fileId;
        if(updateuserface(url,id) == 1){
            return ("更新成功！！  url=" + url);
        }
        return ("更新失败！！");
    }
}

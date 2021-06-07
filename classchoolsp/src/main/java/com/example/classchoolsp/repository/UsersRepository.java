package com.example.classchoolsp.repository;

import com.example.classchoolsp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UsersRepository extends JpaRepository<Users,String> {
//    public Integer updateHeader(MultipartFile file, String userid, HttpServletRequest request);
//    public void downloadHeader(String name, HttpServletResponse response);
}

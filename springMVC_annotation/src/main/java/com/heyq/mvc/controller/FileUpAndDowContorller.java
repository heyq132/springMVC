package com.heyq.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @author heyq
 * @create 2022-10-11-17:10
 */
@Controller
public class FileUpAndDowContorller {

    @RequestMapping("/testDow")
    public ResponseEntity<byte[]> testDow(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/static/img/1.png");
        FileInputStream inputStream = new FileInputStream(realPath);
        byte[] bytes=new byte[inputStream.available()];
        inputStream.read(bytes);
        MultiValueMap<String,String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity=new ResponseEntity<>(bytes,headers,status);
        inputStream.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {
        String filename = photo.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        filename= UUID.randomUUID().toString()+suffix;

        ServletContext servletContext = session.getServletContext();
        String path = servletContext.getRealPath("photo");
        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        String name=path+File.separator+filename;
        photo.transferTo(new File(name));
        return "success";
    }
}

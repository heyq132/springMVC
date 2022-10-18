package com.heyq.mvc.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @author heyq
 * @create 2022-10-10-11:06
 */

@Controller
public class FileUpAndDowController {

    @RequestMapping("/testDow")
    public ResponseEntity<byte[]> testDow(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.png");
        //创建输入流
        FileInputStream inputStream = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[inputStream.available()];
        //将流读到字节数组中
        inputStream.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.png");
        //设置响应状态码
        HttpStatus Status = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, Status);
        //关闭输入流
        inputStream.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        //获取上传的文件的文件名
        String filename = photo.getOriginalFilename();
        //获取上传文件的后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //将UUID作为文件名   replaceAll替换字符串
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        //将uuid和后缀名拼接后的结果作为最终的文件名
        filename = uuid + suffixName;

        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photopath = servletContext.getRealPath("photo");
        File file = new File(photopath);
        //判断photopath所对应路径是否存在
        if (!file.exists()) {
            //若存在，则创建目录
            file.mkdir();
        }
        String finalpath = photopath + File.separator + filename;
        //实现上传功能
        photo.transferTo(new File(finalpath));
        return "success";
    }
}

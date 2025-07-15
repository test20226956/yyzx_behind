package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.util.AliOSSUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/FileController")
@CrossOrigin("*")
@Slf4j
public class FileController {
    //阿里云上传文件实现
    @Autowired
    AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public ResponseBean uploadFile(MultipartFile file) throws Exception {
        log.info("文件上传 文件名 {}", file.getOriginalFilename());
        String url = aliOSSUtils.upload(file);
        log.info("文件上传完成 文件访问的url:{}", url);
        return new ResponseBean<>(200, "上传成功", url);
    }
}

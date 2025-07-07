package com.neusoft.SP01.controller;

import cn.hutool.core.io.FileUtil;
import com.neusoft.SP01.po.ResponseBean;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/FileController")
@CrossOrigin("*")
public class FileController {
    private static final String ROOT_PATH = System.getProperty("user.dir") + "/files";
    //文件上传
    @PostMapping("/upload")
    public ResponseBean upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();//获取到原始的文件名 aaa.png
        long flag = System.currentTimeMillis();//唯一标识
        String fileName = flag + "_" + originalFilename;//123548987_aa.png
        File finalFile = new File(ROOT_PATH + "/" + fileName);//最终存到磁盘的文件对象
        if(!finalFile.getParentFile().exists()){  //如果父级目录不存在，就需要创建
            finalFile.getParentFile().mkdirs();
        }
        file.transferTo(finalFile);
        //返回文件的url
        String url = "http://localhost:9100/FileController/download?fileName=" + fileName;
        return new ResponseBean<>(200,"上传成功",url);

    }
    //文件下载
    @GetMapping("/download")
    public void download(String fileName, HttpServletResponse response) throws IOException {
        File file = new File(ROOT_PATH + "/" + fileName); //文件在磁盘存储的对象
        ServletOutputStream os = response.getOutputStream();
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        response.setContentType("application/octet-stream");
//        os.write(FileUtil.readBytes(file));
        FileUtil.writeToStream(file,os);
        os.flush();
        os.close();
    }
}

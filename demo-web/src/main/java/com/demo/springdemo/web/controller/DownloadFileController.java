package com.demo.springdemo.web.controller;

import com.jbj.springdemo.entity.ReturnCorpVO;
import com.jbj.springdemo.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/demo/")
public class DownloadFileController {
    @RequestMapping("/download")
    public void getAndDownloadExcelFile(HttpServletRequest request, HttpServletResponse response){
        //test data
        List data=new ArrayList();
        for(int i=0;i<100;i++){
            ReturnCorpVO r=new ReturnCorpVO("corp"+i,"account"+i,"project"+i,"close");
            data.add(r);
        }

        //file name with time
        String fileName="Data"+System.currentTimeMillis();
        //get workbook and put content to input stream
        Workbook wb = ExcelUtil.getExcel(data);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);


        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName,"UTF-8")+".xlsx");
            //read file content and put into response output
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

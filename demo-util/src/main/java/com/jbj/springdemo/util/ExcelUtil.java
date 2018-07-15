package com.jbj.springdemo.util;

import com.jbj.springdemo.entity.ReturnCorpVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.List;


public class ExcelUtil {
    public  static Workbook getExcel(List<ReturnCorpVO> data){
        Workbook wb=new HSSFWorkbook();
        Sheet s=wb.createSheet("CorpProjectData");
        Row title=s.createRow(0);
        title.createCell(0).setCellValue("公司");
        title.createCell(1).setCellValue("账户");
        title.createCell(2).setCellValue("项目");
        title.createCell(3).setCellValue("状态");
        for(int i=1;i<data.size();i++) {
            ReturnCorpVO rowData=data.get(i);
            Row r=s.createRow(i);
            r.createCell(0).setCellValue(rowData.getCorpInfo());
            r.createCell(1).setCellValue(rowData.getAccountInfo());
            r.createCell(2).setCellValue(rowData.getProjectName());
            r.createCell(3).setCellValue(rowData.getStatus());
        }
        return wb;
    }

    public static void main(String[] args) {
        List l=new ArrayList();
        for(int i=0;i<100;i++){
            ReturnCorpVO r=new ReturnCorpVO("corp"+i,"account"+i,"project"+i,"close");
            l.add(r);
        }
        Sheet s=getExcel(l).getSheet("CorpProjectData");
        for(Row r:s){
            System.out.print(r.getCell(0).getStringCellValue()+",");
            System.out.print(r.getCell(1).getStringCellValue()+",");
            System.out.print(r.getCell(2).getStringCellValue()+",");
            System.out.print(r.getCell(3).getStringCellValue()+",");
            System.out.println();
        }
    }

}

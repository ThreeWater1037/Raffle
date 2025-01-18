package com.edu.hit.raffle.common;

import com.edu.hit.raffle.pojo.User;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static List<User> excelToOrderForXls(MultipartFile file){
        // 新建一个list，用于存放解析结果
        List<User> list=new ArrayList<>();
        try {
            // 拿到对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            // 一个excel可能有多个sheet,所以遍历sheet
            for (int i = 0; i <workbook.getNumberOfSheets() ; i++) {
                // 拿到sheet对象
                HSSFSheet sheet = workbook.getSheetAt(i);
//                System.out.println("行数"+sheet.getPhysicalNumberOfRows());
                // 遍历每一行
                for (int j = 0; j <sheet.getPhysicalNumberOfRows() ; j++) {
                    //略过首行，即标题行
                    if(j==0){
                        continue;
                    }
                    // 拿到行的对象
                    HSSFRow row = sheet.getRow(j);
                    // 即使你的表格中没有空行，但也可能会被解析出一些空行，所以我们略过空行，否则会报错
                    if (row==null){
                        continue;
                    }
//                    System.out.println("列数"+row.getPhysicalNumberOfCells());
                    // new一个自己的实体类的对象，方便一会儿将解析出来的值存放进去
                    User user = new User();
                    // 注意下面这种方法是最简单但是也最死板的方法，就是固定excel的表头
                    // 每一列只能是对应的字段。一旦excel的某两列相互替换一下位置
                    // 那么写入order的值就乱了

                    // 遍历一行中的每一个单元格
                    for (int k = 0; k <row.getPhysicalNumberOfCells() ; k++) {
                        // 写固定了，每一列内容不能变
                        if(k==0){
                            //乘客姓名
                            user.setName(row.getCell(k).getStringCellValue());
                        }
                        else if(k==1){
                            // 乘客电话
                            user.setPhone(row.getCell(k).getStringCellValue());
                        }
                        else ;
                    }
                    // 将order对象添加到list中
                    list.add(user);
//                    System.out.println(order);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<User> excelToOrderForXlsx(MultipartFile file){
        // 新建一个list，用于存放解析结果
        List<User> list=new ArrayList<>();
        try {
            // 拿到对象
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            // 一个excel可能有多个sheet,所以遍历sheet
            for (int i = 0; i <workbook.getNumberOfSheets() ; i++) {
                // 拿到sheet对象
                XSSFSheet sheet = workbook.getSheetAt(i);
//                System.out.println("行数"+sheet.getPhysicalNumberOfRows());
                // 遍历每一行
                for (int j = 0; j <sheet.getPhysicalNumberOfRows() ; j++) {
                    //略过首行，即标题行
                    if(j==0){
                        continue;
                    }
                    // 拿到行的对象
                    XSSFRow row = sheet.getRow(j);
                    // 即使你的表格中没有空行，但也可能会被解析出一些空行，所以我们略过空行，否则会报错
                    if (row==null){
                        continue;
                    }
//                    System.out.println("列数"+row.getPhysicalNumberOfCells());
                    // new一个自己的实体类的对象，方便一会儿将解析出来的值存放进去
                    User user = new User();
                    // 注意下面这种方法是最简单但是也最死板的方法，就是固定excel的表头
                    // 每一列只能是对应的字段。一旦excel的某两列相互替换一下位置
                    // 那么写入order的值就乱了

                    // 遍历一行中的每一个单元格
                    for (int k = 0; k <row.getPhysicalNumberOfCells() ; k++) {
                        // 写固定了，每一列内容不能变
                        if(k==0){
                            //乘客姓名
                            user.setName(row.getCell(k).getStringCellValue());
                        }
                        else if(k==1){
                            // 乘客电话
                            user.setPhone(row.getCell(k).getStringCellValue());
                        }
                        else ;
                    }
                    // 将order对象添加到list中
                    list.add(user);
//                    System.out.println(order);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}



package com.nanfang.backend;



import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author nanfang
 * @create 2020/02/13/12:17
 */
public class Main {
    public static void main(String[] args){
        insertSQL(readExcel());
    }
    public static List readExcel() {
        List<String> list=new ArrayList<>();
        try{
            File xlsFile=new File("./test.xls");
            Workbook workbook= WorkbookFactory.create(xlsFile);
            Sheet sheet=workbook.getSheetAt(0);
            int rows=sheet.getLastRowNum()+1;
            //读取数据
            for(int row=0;row<rows;row++){
                Row r=sheet.getRow(row);
                list.add(r.getCell(0).getStringCellValue());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static void  insertSQL(List<String> list){
        //定义需要的对象
        PreparedStatement ps=null;
        Connection conn=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://118.25.61.247:3306/nanfang?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
            String usernName = "root";  //登录数据库的账号
            String password = "songzhe123";  //登录数据库的密码
            conn = DriverManager.getConnection(url, usernName, password);
            Statement statement = conn.createStatement();
            String sql="insert into user(uid,password) values(?,?)";
            ps=conn.prepareStatement(sql);
            for(int i=0;i<list.size();i++){
                ps.setString(1,list.get(i));
                ps.setString(2,list.get(i));
                ps.executeUpdate();
            }
            conn.close();
            System.out.println("sql插入完毕！！！");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

package cn.tedu;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询的页数");
        int page = sc.nextInt();
        System.out.println("请输入查询的条数");
        int count = sc.nextInt();
        if(page<1||count<1){
            System.out.println("输入错误");
            return;
        }
        try(Connection conn = D8Utils.getConn()){
            String sql ="select*from user limit ?,?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1,(page-1)*count);
            ps.setInt(2,count);
            ResultSet rs =  ps.executeQuery();
                    while(rs.next()){
                        int id=rs.getInt(1);
                        String username =rs.getString(2);
                        String passwrod =rs.getString(3);
                        System.out.println(id+":"+username+":"+passwrod);
                    }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

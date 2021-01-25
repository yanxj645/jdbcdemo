package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        //获取连接
        try (Connection conn = D8Utils.getConn()){
            String sql = "select id from user where username=? and password=?" ;
           PreparedStatement ps =conn.prepareStatement(sql);
           ps.setString(1,username);
           ps.setString(1,password);
           ResultSet rs= ps.executeQuery();
           if (rs.next()){
               System.out.println("登陆成功");
           }else{
               System.out.println("登陆失败");
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

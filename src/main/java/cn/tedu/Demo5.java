package cn.tedu;

import java.sql.*;
import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        //获取连接
        try (Connection conn = D8Utils.getConn()){
//            Statement s = conn.createStatement();
//            ResultSet rs = s.executeQuery("select id from user where username='"+username+"' and password='"+password+"'" );
            //使用预编译的SQL执行对象解决SQL注入漏洞
            String sql = "select id from user where username=? and password=?";
            //由于预编译的SQL执行对象提起将SQL语句的逻辑部分编译锁死,用户输入的内容不会对原有逻辑造成改动,从而剞劂SQL注入的问题
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(1,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
//                System.out.println("用户已存在");
//                return;
                System.out.println("登陆成功");
            }else {
                System.out.println("登陆失败");
            }
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc .nextLine();
        try(Connection conn = D8Utils.getConn()){
            String sql = "insert into user values(null,?,'abc')";
            PreparedStatement ps = conn.prepareStatement(sql,
            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,username);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id =rs.getInt(1);
            System.out.println("执行完成! id="+id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

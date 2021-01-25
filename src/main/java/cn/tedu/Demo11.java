package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入球队名称");
        String teamName = sc.nextLine();
        System.out.println("请输入球员名称");
        String playerName = sc.nextLine();
        try(Connection conn=D8Utils.getConn()){
            //1把得到的球队名 保存到球队表中同时获取自增id
            //2把球员名和球队名自增id一起保存到球员表中
            String sql ="insert into team values(null,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,teamName);
            ps.executeUpdate();
            //获取主键值的结果集
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int teamid = rs.getInt(1);
            String pSql="insert into player values(null,?,?)";
            PreparedStatement pps = conn.prepareStatement(pSql);
            pps.setString(1,playerName);
            pps.setInt(2,teamid);
            pps.executeUpdate();
            System.out.println("执行完成");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

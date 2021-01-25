package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入球队名称");
        String teamName = sc.nextLine();
        System.out.println("请输入球员名称");
        String playerName = sc.nextLine();
        try(Connection conn=D8Utils.getConn()){
            //查询是否存在球队
            String sql = "select id from team where name=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,teamName);
            ResultSet rs = ps.executeQuery();
            int teamId;
            if(rs.next()){
                teamId = rs.getInt(1);
            }else{//没有球队 添加球队
                String tsql = "insert into team values(null,?)";
                PreparedStatement tps = conn.prepareStatement(tsql,Statement.RETURN_GENERATED_KEYS);
                tps.setString(1,teamName);
                tps.executeUpdate();
                ResultSet trs = tps.getGeneratedKeys();
                trs.next();
                teamId = trs.getInt(1);

            }
            String psql = "insert into player values(null,?,?)";
            PreparedStatement pps = conn.prepareStatement(psql);
            pps.setString(1,playerName);
            pps.setInt(2,teamId);
            pps.executeUpdate();
            System.out.println("执行完成");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

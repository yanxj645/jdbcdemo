package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo07 {
    public static void main(String[] args) {
        try(Connection conn = D8Utils.getConn();){
            String sql = "insert into user values(null,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i=1;i<=100;i++){
                ps.setString(1,"name"+i);
                ps.setString(2,"pw"+i);
                ps.addBatch();
                if (i%20==0){
                    ps.executeBatch();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

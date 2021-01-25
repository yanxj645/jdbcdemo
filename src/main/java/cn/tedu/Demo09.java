package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo09 {
    public static void main(String[] args) {
        try(Connection conn=D8Utils.getConn()){
            String sql = "insert into user values(null,'诸葛丽','123456')";
            Statement s = conn.createStatement();
            s.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = s.getGeneratedKeys();
            rs.next();
            int id =rs.getInt(1);
            System.out.println("执行完成!id="+id);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

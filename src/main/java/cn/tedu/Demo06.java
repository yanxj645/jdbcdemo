package cn.tedu;

import java.sql.Connection;
import java.sql.Statement;

public class Demo06 {
    public static void main(String[] args) {
        //获取连接
        try(Connection conn = D8Utils.getConn()){
            String sql1 ="insert into user values(null,'aaa','123456')";
            String sql2 ="insert into user values(null,'bbb','123456')";
            String sql3 ="insert into user values(null,'ccc','123456')";
            Statement s = conn.createStatement();
//            s.executeUpdate(1);
//            s.executeUpdate(2);
//            s.executeUpdate(3);
            s.addBatch(sql1);
            s.addBatch(sql2);
            s.addBatch(sql3);
            s.executeBatch();
            System.out.println("执行完成");
        }catch(Exception e){
            e.printStackTrace();
        }

        }
    }


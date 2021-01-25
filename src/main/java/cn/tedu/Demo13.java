package cn.tedu;

import java.sql.*;

public class Demo13 {
    public static void main(String[] args) {
        //元数据:数据库元数据,表相关元数据
        //获取连接
        try (Connection conn = D8Utils.getConn();){
            //获取数据库元数据
            DatabaseMetaData dmd = conn.getMetaData();
            System.out.println("数据库名:"+dmd.getDatabaseProductName());
            System.out.println("数据库url:"+dmd.getURL());
            System.out.println("数据库屈东明:"+dmd.getDriverName());
            System.out.println("s数据库用户名:"+dmd.getUserName());
            //获取表的元数据,先写查询
            String sql = "select * from emp";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            //获取表相关元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取表字段数量
            int count = rsmd.getColumnCount();
            //遍历表字段的名称和类型
            for(int i=0;i<count;i++){
                String name =rsmd.getColumnName(i+1);
                String type = rsmd.getColumnTypeName(i+1);
                System.out.println(name+":"+type);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

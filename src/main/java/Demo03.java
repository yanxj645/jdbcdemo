import cn.tedu.D8Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo03 {
    public static void getConn()throws Exception {
        try (Connection conn = D8Utils.getConn()) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select ename from emp");
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


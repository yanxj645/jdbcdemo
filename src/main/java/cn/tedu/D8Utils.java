package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class D8Utils {
    private  static DruidDataSource dds;
    static {
        //创建读取配置文件的属性对象
        Properties p = new Properties();
        //得到文件输入流
        InputStream ips =D8Utils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            p.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取配置文件中的数据
        String driver =p.getProperty("db.driver");
        String url =p.getProperty("db.url");
        String username =p.getProperty("db.username");
        String password =p.getProperty("db.password");
        String maxActive =p.getProperty("db.maxActive");
        String initialSize =p.getProperty("db.initialSize");

        //创建数据库连接池对象
         dds =new DruidDataSource();
        //设置数据库连接信息
        dds.setDriverClassName(driver);
        dds.setUrl(url);
        dds.setUsername(username);
        dds.setPassword(password);
        dds.setInitialSize(Integer.parseInt(initialSize));
        dds.setMaxActive(Integer.parseInt(maxActive));
        //注册驱动

        //获取连接数据库

    }
    public static Connection getConn() throws Exception {
        Connection conn = dds.getConnection();

        return conn;
    }
}

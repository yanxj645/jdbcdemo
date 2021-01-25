package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class demo03 {
    public static void main(String[] args) throws IOException {
        //创建读取配置文件的属性对象
        Properties p = new Properties();
        //获取resource目录下的文件输入流
        InputStream ips = demo03.class.getClassLoader().getResourceAsStream("my.popeties");
        //让配置文件和属性对象建立关系 异常抛出
        p.load(ips);
        //读取配置文件中的数据
        String name =p.getProperty("name");
        //属性配置文件中只能或去除字符串类型
        String age=p.getProperty("age");
        System.out.println(name+":"+age);
    }
}

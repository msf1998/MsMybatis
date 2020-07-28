package com.mfs.msibatis;

import com.mfs.msibatis.session.SqlSessionFactory;
import com.mfs.msibatis.session.SqlSessionFactoryBuilder;
import com.mysql.jdbc.Driver;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import javax.management.modelmbean.XMLParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, XMLParseException {
        /*String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";
        //注册数据库驱动
        Class.forName(driver);
        //链接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);*/

        new SqlSessionFactoryBuilder().build(new FileReader("src/main/resources/example/xml/MsMybatis-config.xml"));
    }
}

package com.mfs.msibatis.session;

import com.mfs.msibatis.config.Configuration;
import com.mfs.msibatis.xml.XMLConfigBuilder;

import javax.management.modelmbean.XMLParseException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @Author mfs1998
 * @Date 2020/07/28
 * */
public class SqlSessionFactoryBuilder {

    //面向客户端程序员的接口
    public SqlSessionFactory build(Reader reader) throws XMLParseException {
        return build(new XMLConfigBuilder(reader).parse());
    }

    public SqlSessionFactory build(InputStream inputStream) throws XMLParseException {
        return build(new XMLConfigBuilder(inputStream).parse());
    }


    //面向底层的接口
    public SqlSessionFactory build(Configuration configuration){
        System.out.println(configuration.getDriver() + " " +configuration.getPassword() + " " +configuration.getUrl() + " " + configuration.getUser());
        return null;
    }
    /*
    * 写两种接口的好处：
    * 1. 分别为客户端程序员、底层程序提供友好可用的接口。客户端程序员对接口参数的要求：丰富、易于构造；底层程序对接口参数的要求：易用，只需要极少量的
    * 操作便可以获取想要的信息
    * 2. 将xml解析与xml解析出来的内容的应用两部分分隔开
    * */
}

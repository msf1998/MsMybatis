package com.mfs.msibatis.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.io.Reader;

/**
 * @Author mfs1998
 * @Date 2020/07/28
 * */
/*
 * xml -> Document构造器
 * */
public class XMLDocumentBuilder {
    private Reader reader;
    private InputStream inputStream;
    public XMLDocumentBuilder(Reader reader) {
        this.reader = reader;
    }

    public XMLDocumentBuilder(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /*
    * reader/inputStream -> document
    * */
    public Document parse() {
        if (reader != null) {
            try {
                return new SAXReader().read(reader);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        } else if(inputStream != null) {
            try {
                return new SAXReader().read(inputStream);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

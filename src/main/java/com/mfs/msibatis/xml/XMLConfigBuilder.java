package com.mfs.msibatis.xml;


/*
* XML->Configuration的构造器
* */

import com.mfs.msibatis.config.Configuration;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import javax.management.modelmbean.XMLParseException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author mfs1998
 * @Date 2020/07/28
 * */
public class XMLConfigBuilder {
    //xml的Document对象
    private XMLDocumentBuilder xmlDocumentBuilder;
    private Boolean parsed;

    public XMLConfigBuilder(Reader reader){
        this(new XMLDocumentBuilder(reader));
    }

    public XMLConfigBuilder(InputStream inputStream){
        this(new XMLDocumentBuilder(inputStream));
    }

    public XMLConfigBuilder(XMLDocumentBuilder xmlDocumentBuilder) {
        this.xmlDocumentBuilder = xmlDocumentBuilder;
        this.parsed = false;
    }

    public Configuration parse() throws XMLParseException {
        Document document = xmlDocumentBuilder.parse();
        if (document == null) {
            throw new XMLParseException("This may not a XML file");
        }
        Element root = document.getRootElement();
        if (root == null || !root.getName().equals("configuration")) {
            throw new XMLParseException("Can't find configuration element in your configuration file");
        }
        environmentsElement(root.element("environments"));
        return Configuration.getInstance();
    }

    private void environmentsElement(Element element) throws XMLParseException {
        if (element == null) {
            throw new XMLParseException("Can't find environments element in your configuration file");
        }
        Element environment = element.element("environment");
        if (environment == null) {
            throw new XMLParseException("Can't find environment element under environments element");
        }
        Element dataSource = environment.element("dataSource");
        if (dataSource == null) {
            throw new XMLParseException("Can't find dataSource element under environment element");
        }
        List<Element> properties = dataSource.elements("property");
        Map<String,String> map = new HashMap<String, String>();
        for (Element e : properties) {
            Attribute name = e.attribute("name");
            Attribute value = e.attribute("value");
            if (name == null) {
                throw new IllegalAccessError("Can't find name element in property element");
            }
            if (value == null) {
                throw new IllegalAccessError("Can't find value element in property element");
            }
            map.put(name.getValue(),value.getValue());
        }
        Configuration configuration = Configuration.getInstance();
        if (map.get("driver") != null) {
            configuration.setDriver(map.get("driver"));
        }
        if (map.get("url") != null) {
            configuration.setUrl(map.get("url"));
        }
        if (map.get("user") != null) {
            configuration.setUser(map.get("user"));
        }
        if (map.get("password") != null) {
            configuration.setPassword(map.get("password"));
        }
    }
}

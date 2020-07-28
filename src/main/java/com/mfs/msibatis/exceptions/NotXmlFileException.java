package com.mfs.msibatis.exceptions;

import jdk.internal.util.xml.XMLStreamException;

public class NotXmlFileException extends XMLStreamException {
    public NotXmlFileException(){
        super();
    }
    public NotXmlFileException(String msg) {
        super(msg);
    }
}

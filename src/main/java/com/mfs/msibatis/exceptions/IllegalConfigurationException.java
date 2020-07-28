package com.mfs.msibatis.exceptions;

import jdk.internal.util.xml.XMLStreamException;

public class IllegalConfigurationException extends XMLStreamException {
    public IllegalConfigurationException(){
        super();
    }
    public IllegalConfigurationException(String msg) {
        super(msg);
    }
}

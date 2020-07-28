package com.mfs.msibatis.config;

public class Configuration {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test";
    private String user = "root";
    private String password = "123456";

    private static class ConfigurationHolder {
        public static final Configuration CONFIGURATION = new Configuration();
    }

    public static Configuration getInstance() {
        return ConfigurationHolder.CONFIGURATION;
    }

    private Configuration(){
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

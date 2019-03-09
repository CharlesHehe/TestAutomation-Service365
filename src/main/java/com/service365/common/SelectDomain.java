package com.service365.common;

import java.util.Properties;

public class SelectDomain {
    public Properties properties;
    public Properties selectDomain(String environment){

        if (environment.equals("DEV")) {
            properties = PropertiesUtils.loadProp("dev.properties");
        } else if (environment.equals("UAT")) {
            properties = PropertiesUtils.loadProp("uat.properties");
        } else if(environment.equals("PROD")){
            properties = PropertiesUtils.loadProp("production.properties");
        }else {
            properties = PropertiesUtils.loadProp("uat.properties");
        }
        return properties;
    }
}

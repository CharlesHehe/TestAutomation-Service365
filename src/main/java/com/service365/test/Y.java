package com.service365.test;

import com.service365.common.PropertiesUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class Y {
    public Properties properties;

    @BeforeTest
    public void getConfig(){
        properties =  PropertiesUtils.loadProp("config.properties");
    }

    @Test
    public void t(){
        properties.getProperty("myAddressURL");
    }
}

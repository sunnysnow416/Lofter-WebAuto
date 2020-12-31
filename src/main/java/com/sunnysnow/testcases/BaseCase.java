package com.sunnysnow.testcases;

import com.sunnysnow.task.IndexTask;
import com.sunnysnow.task.LoginTask;
import com.sunnysnow.utils.DriverBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Locale;
import java.util.ResourceBundle;

public class BaseCase {
    LoginTask loginTask;
    DriverBase driverBase;
    ResourceBundle bundle ;

    @BeforeClass
    public void BeforeTest(){
        bundle = ResourceBundle.getBundle("dataLogin", Locale.CHINA);
        driverBase=new DriverBase("chrome");
        loginTask = new LoginTask(driverBase);
        driverBase.get(bundle.getString("login.url"));
        driverBase.sleep(3);
        loginTask.login(bundle.getString("username"),bundle.getString("passWord"));
    }


    @AfterClass
    public void AfterTest(){
        driverBase.close();
    }
}

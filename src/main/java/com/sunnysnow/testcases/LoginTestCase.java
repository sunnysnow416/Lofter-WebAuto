package com.sunnysnow.testcases;

import com.sunnysnow.task.IndexTask;
import com.sunnysnow.task.LoginTask;
import com.sunnysnow.utils.DriverBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginTestCase {
    LoginTask loginTask;
    DriverBase driverBase;
    IndexTask indexTask;
    ResourceBundle bundle ;

    @BeforeClass
    public void BeforeTest(){
        bundle = ResourceBundle.getBundle("dataLogin", Locale.CHINA);
        driverBase=new DriverBase("chrome");
        loginTask = new LoginTask(driverBase);
        indexTask = new IndexTask(driverBase);
        driverBase.get(bundle.getString("login.url"));
        driverBase.sleep(3);

    }

    @Test(description = "成功登录")
    public void loginTest(){
        loginTask.login(bundle.getString("username"),bundle.getString("passWord"));
        Assert.assertEquals(indexTask.showUser(),"maoqingqingmao");
        indexTask.logout();
    }

    @AfterClass
    public void afterTest(){
        driverBase.close();
    }
}

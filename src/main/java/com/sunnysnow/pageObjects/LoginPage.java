package com.sunnysnow.pageObjects;

import com.sunnysnow.utils.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginPage extends BasePage{
    /**
     * 构造函数
     * @param driverBase
     */
    public LoginPage(DriverBase driverBase) {
        super(driverBase);
        bundle= ResourceBundle.getBundle("pageLogin", Locale.CHINA);
    }

    /**
     * 密码登录方式按钮
     * @return
     */
    public WebElement getLoginByPwdEle() {
        WebElement ele=null;
        try {
            ele = getElementObject("loginPage.tab.pwdway");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ele;
    }

    /**
     * 邮箱登陆按钮
     * @return
     */
    public WebElement getPwdWayEmailEle(){
        WebElement elementObject =null;
        try {
            elementObject = getElementObject("loginPage.tab.pwdway.email");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementObject;
    }

    /**
     * iframe
     * @return
     */
    public WebElement getIframeEle(){
        WebElement elementObject =null;
        try {
            elementObject = getElementObject("loginPage.iframe");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementObject;
    }

    /**
     * 用户名输入框
     * @return
     */
    public WebElement getNameEle(){
        WebElement elementObject =null;
        try {
            elementObject = getElementObject("loginPage.email.userName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementObject;
    }

    /**
     * 密码输入框
     * @return
     */
    public WebElement getPwdEle(){
        WebElement elementObject =null;
        try {
            elementObject = getElementObject("loginPage.email.passWord");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementObject;
    }

    /**
     * 同意勾选框
     * @return
     */
    public WebElement getAgreeEle(){
        WebElement elementObject =null;
        try {
            elementObject = getElementObject("loginPage.agree");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementObject;
    }

    /**
     * 登录按钮
     * @return
     */
    public WebElement getLoginBtnEle(){
        WebElement elementObject =null;
        try {
            elementObject = getElementObject("loginPage.loginBtn");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementObject;
    }
}

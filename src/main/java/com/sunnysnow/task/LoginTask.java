package com.sunnysnow.task;

import com.sunnysnow.pageObjects.LoginPage;
import com.sunnysnow.utils.DriverBase;

public class LoginTask extends BaseTask {
    LoginPage loginPage;
    /**
     * 构造函数
     *
     * @param driverBase
     */
    public LoginTask(DriverBase driverBase) {
        super(driverBase);
        loginPage=new LoginPage(driverBase);
    }

    /**
     * 登录操作
     * @param username
     * @param pwd
     */
    public void login(String username, String pwd) {
        //切换到密码登录
        click(loginPage.getLoginByPwdEle());
        //切换到邮箱方式登录
        click(loginPage.getPwdWayEmailEle());
        driverBase.sleep(3);
        //切换iframe
        getIframe(loginPage.getIframeEle());
        //输入用户名
        sendKeys(loginPage.getNameEle(),username);
        //输入密码
        sendKeys(loginPage.getPwdEle(),pwd);
        //勾选同意
        click(loginPage.getAgreeEle());
        //点击登录按钮
        click(loginPage.getLoginBtnEle());
        //等待
        driverBase.sleep(3);
    }
}

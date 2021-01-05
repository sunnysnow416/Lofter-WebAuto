package com.sunnysnow.utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TakeScreenshotListener extends TestListenerAdapter  {
    @Override
    public void onTestFailure(ITestResult tr){
        try {

            super.onTestFailure(tr);
            // 类名为全类名，包含包名：com.testcases.LoginTest
            String className = tr.getTestClass().getName();
            // 方法名为执行的方法：testWrongPasswordLogin
            String methodName = tr.getMethod().getMethodName();
            //调用快照方法
            ScreenShort sc=new ScreenShort(DriverBase.getDriver());
            sc.takeScreenshot(className,methodName);

        } catch (SecurityException e)
        {
            e.printStackTrace();
        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }
}

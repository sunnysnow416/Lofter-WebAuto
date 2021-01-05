package com.sunnysnow.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShort {
    public WebDriver driver;

    /**
     * 构造函数初始化
     * @param driver
     */
    public ScreenShort(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String screenPath){
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenPath));
        }
        catch (IOException e) {
            LoggerUtil.info("Screen shot error: " + screenPath);
        }
    }

    public void takeScreenshot(String className,String methodName){
        LoggerUtil.info("开始截图");
        String screenName=className+"_"+methodName+"_"+String.valueOf(new Date().getTime()+".jpg");
        //获取目标跟路劲classes
        String path = this.getClass().getResource("/").getPath();
        //System.out.println("path:"+path);
        File file=new File(path+"\\imag\\");
        if (!file.exists())
            file.mkdirs();
        String screenPath = file.getAbsolutePath() + "\\" + screenName;
        //System.out.println(screenPath);
        this.takeScreenshot(screenPath);
        LoggerUtil.info("截图成功");
    }
}

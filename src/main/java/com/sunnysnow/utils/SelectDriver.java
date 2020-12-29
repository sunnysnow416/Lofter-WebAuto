package com.sunnysnow.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelectDriver {
    public WebDriver driverName(String browser){
        //equalsIgnoreCase :不区分大小写
        if(browser.equalsIgnoreCase("fireFox")){
            System.setProperty("webdriver.firefox.marionette","E:\\eclipse\\IJworkspace\\allitems\\Lofter-Web\\src\\main\\resources\\tools\\geckodriver.exe");
            return new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            return new InternetExplorerDriver(capabilities);
        }else{
            System.setProperty("webdriver.chrome.driver", "E:\\eclipse\\IJworkspace\\allitems\\Lofter-Web\\src\\main\\resources\\tools\\chromedriver.exe");
            return new ChromeDriver();
        }
    }
}

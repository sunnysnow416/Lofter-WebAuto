package com.sunnysnow.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
    封装与浏览器相关的各种操作：
    包括返回driver，关闭driver，获取handle，获取alert等操作
 */
public class DriverBase {
    public static WebDriver driver;

    //构造方法
    public DriverBase(String browser) {
        SelectDriver selectDriver = new SelectDriver();
        //将返回的driver赋值给当前的webdriver
        this.driver = selectDriver.driverName(browser);
        this.driver.manage().window().maximize();
    }

    /**
     * 根据传入的参数打开相应的浏览器，并且返回一个浏览器对象
     * @param driver
     * @param num
     * @return
     */
    /*public WebDriver openBrowser(WebDriver driver,int num){

        switch (num){
            case 1:
                System.setProperty("webdriver.ie.driver", "D:\\Auto\\AutoTest\\selenium\\IEDriverServer_x64_2.31.0\\IEDriverServer.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                driver = new InternetExplorerDriver(capabilities);
                break;
            case 2:
                driver=new FirefoxDriver();
                break;
            case 3:
                System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case 4:
                driver=new HtmlUnitDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }*/

    /**
     * 获取driver
     *
     * @return
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * 关闭浏览器驱动
     */
    public void stopDriver() {
        LoggerUtil.info("停止浏览器");
        driver.close();
    }

    /**
     * 关闭浏览器
     */
    public void close() {
        driver.close();
    }

    /**
     * 刷新
     */
    public void refreash(){
        driver.navigate().refresh();
    }

    /**
     * 屏幕最大化
     */
    public void getWindowMax(){
        driver.manage().window().maximize();
    }

    /**
     * 返回
     */
    public void back(){
        driver.navigate().back();
    }

    /**
     * 封装Element方法
     */
/*    public WebElement findElement(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }*/

    /*
     * get封装
     * */
    public void get(String url) {
        driver.get(url);
    }

    /**
     * 休眠封装
     * @param num
     */
    public void sleep(int num) {
        try {
            Thread.sleep(num*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开指定的URL
     * @param url
     */
    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    /**
     * 判断是否存在alert,存在返回true，否则返回false
     * @return
     */
    public boolean existAlert(){
        try{
            Alert alert=driver.switchTo().alert();
            return true;
        }catch (Exception e){
            LoggerUtil.info("不存在alert");
            return false;
        }
    }

    /**
     * 返回一个alert
     * @return
     */
    public Alert alert(){
        Alert alert=driver.switchTo().alert();
        return alert;
    }

    /**
     * 切换alert窗口
     * */
    public void switchAlert() {
        driver.switchTo().alert();
    }

    /**
     * 模态框切换
     * */
    public void switchToMode() {
        driver.switchTo().activeElement();
    }

    /**
     * 获取cookcie
     * @return
     * */
    public Set<Cookie> getCookie(){
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }


    /**
     * 删除cookie
     * */
    public void deleteCookie(){
        driver.manage().deleteAllCookies();
    }

    /**
     * 设置cookie
     * */
    public void setCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    /**
     * 获取当前系统窗口list
     * */
    public List<String> getWindowsHandles(){
        Set<String> winHandels = driver.getWindowHandles();
        List<String> handles = new ArrayList<String>(winHandels);
        return handles;
    }

    /*
     * 获取当前窗口
     * **/
    public String getWindowHandle(){
        return driver.getWindowHandle();
    }


    /**
     * 切换windows窗口
     * */
    public void switchWindows(String name){
        driver.switchTo().window(name);
    }

    /**
     * 获取当前url
     * */
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    /**
     * 获取title
     * */
    public String getTitle(){
        return driver.getTitle();
    }

    /**
     * 封装定位一组elements的方法
     * */
/*    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }*/

    /**
     * @author shao
     * 释放ifram
     * */
    public WebDriver resetIFrame(){
        return driver.switchTo().defaultContent();
    }

    /**
     * 获取新的iframe
     */
    public WebDriver getIframe(WebElement element){
        return driver.switchTo().frame(element);
    }

    /**
     * actionMoveElement
     * */
    public void action(WebElement element){
        Actions action =new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     * 隐式等待
     * 隐式等待就是针对页面的，显式等待是针对元素的。
     */
   /* public void waitForPageLoad(int sends){
        driver.manage().timeouts().implicitlyWait(sends, TimeUnit.SECONDS);
    }
    */
}

package com.sunnysnow.pageObjects;

import com.sunnysnow.utils.DriverBase;
import com.sunnysnow.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/*
    封装与页面元素相关的各种操作：
    比如：
    1.封装找页面元素的方法，返回元素，元素列表，返回By
    2.元素是否显示、元素是否存在
    3.获取元素文本信息
 */
public class BasePage {
    DriverBase driverBase ;
    Properties properties;
    ResourceBundle bundle;

    /**
     * 构造函数
     * @param driverBase
     */
    public BasePage(DriverBase driverBase) {
        this.driverBase = driverBase;
    }

    /**
     * 判断元素是否显示方法
     * @param element
     * @return
     */
    public boolean assertElement(WebElement element){
        return element.isDisplayed();
    }

    /**
     * @author shao
     * 验证元素是否存在
     * */
    public boolean elementExist(By by){
        try{
            driverBase.getDriver().findElement(by);
            return true;
        }catch(NoSuchElementException No){
            LoggerUtil.info("元素不存在");
            return false;
        }
    }

    /**
     * 定位Element
     * @param by
     * @return
     */
    public WebElement element(By by) {
        WebElement ele=driverBase.getDriver().findElement(by);
        return ele;
    }

    /**
     * 层级定位,通过父节点定位到子节点
     * 需要传入父节点和子节点的By
     * @param parentBy
     * @param childrenBy
     * @return
     */
    public WebElement getChildrenElement(By parentBy,By childrenBy){
        WebElement ele = this.element(parentBy);
        return ele.findElement(childrenBy);
    }

    /**
     * 层级定位传入element，以及子的by
     * @param element
     * @param childrenBy
     * @return
     */
    public WebElement getChildrenElement(WebElement element,By childrenBy){
        return element.findElement(childrenBy);
    }

    /**
     *  定位一组elements
     * @param ElementNameInproFile
     * @return
     */
    public List<WebElement> elements (String ElementNameInproFile) throws Exception {
        /*
            根据变量ElementNameInproFile从属性配置文件中读取对象的配置对象
            index.loadApp=id:appdownloadimg4noAppLogin
            ElementNameInproFile的值为index.loadApp
         */
        String locator = bundle.getString(ElementNameInproFile);
        String locatorType = locator.split(":")[0];
        String locatorTValue = locator.split(":")[1];
        if(locatorType.toLowerCase().equals("id")){
            return driverBase.getDriver().findElements(By.id(locatorTValue));
        }else if(locatorType.toLowerCase().equals("name")){
            return driverBase.getDriver().findElements(By.name(locatorTValue));
        }else if (locatorType.toLowerCase().equals("classname")){
            return driverBase.getDriver().findElements(By.className(locatorTValue));
        }else if (locatorType.toLowerCase().equals("tagname")){
            return driverBase.getDriver().findElements(By.tagName(locatorTValue));
        }else if (locatorType.toLowerCase().equals("linktext")){
            return driverBase.getDriver().findElements(By.linkText(locatorTValue));
        }else if (locatorType.toLowerCase().equals("partiallinktext")){
            return driverBase.getDriver().findElements(By.partialLinkText(locatorTValue));
        }else if (locatorType.toLowerCase().equals("xpath")){
            return driverBase.getDriver().findElements(By.xpath(locatorTValue));
        }else if (locatorType.toLowerCase().equals("css")){
            return driverBase.getDriver().findElements(By.cssSelector(locatorTValue));
        }else {
            throw  new Exception("输入的locator type未在程序中定义："+locatorType);
        }
    }

    /**
     * 根据配置文件里的属性关键字按属性查找
     * @param ElementNameInpropFile
     * @return
     * @throws Exception
     */
    public WebElement getElementObject(String ElementNameInpropFile) throws Exception{
        /*
            根据变量ElementNameInproFile从属性配置文件中读取对象的配置对象
            index.loadApp=id:appdownloadimg4noAppLogin
            ElementNameInproFile的值为index.loadApp
         */
        String locator = bundle.getString(ElementNameInpropFile);
        //将配置对象中的地位类型存储locatorType变量，将定位表达式的值存入locatorValue变量
        String locatorType = locator.split(":")[0];
        String locatorValue =locator.split(":")[1];
        if(locatorType.toLowerCase().equals("id"))
            return driverBase.getDriver().findElement(By.id(locatorValue));
        else if(locatorType.toLowerCase().equals("name"))
            return driverBase.getDriver().findElement(By.name(locatorValue));
        else if((locatorType.toLowerCase().equals("classname")))
            return driverBase.getDriver().findElement(By.className(locatorValue));
        else if((locatorType.toLowerCase().equals("tagname")))
            return driverBase.getDriver().findElement(By.tagName(locatorValue));
        else if ((locatorType.toLowerCase().equals("linktext")))
            return driverBase.getDriver().findElement(By.linkText(locatorValue));
        else if ((locatorType.toLowerCase().equals("partiallinktext")))
            return driverBase.getDriver().findElement(By.partialLinkText(locatorValue));
        else if ((locatorType.toLowerCase().equals("xpath")))
            return driverBase.getDriver().findElement(By.xpath(locatorValue));
        else if ((locatorType.toLowerCase().equals("css")))
            return driverBase.getDriver().findElement(By.cssSelector(locatorValue));
        else {
            throw new Exception("输入的locator type未在程序中定义："+locatorType);
        }
    }

    /**
     * 根据配置文件里的属性关键字按属性查找
     * @param ElementNameInpropFile
     * @return
     * @throws Exception
     */
    public By getElementProperty(String ElementNameInpropFile) throws Exception{
         /*
            根据变量ElementNameInproFile从属性配置文件中读取对象的配置对象
            index.loadApp=id:appdownloadimg4noAppLogin
            ElementNameInproFile的值为index.loadApp
         */
        String locator = bundle.getString(ElementNameInpropFile);
        String locatorType = locator.split(":")[0];
        String locatorValue =locator.split(":")[1];
        if(locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);
        else if(locatorType.toLowerCase().equals("name"))
            return By.name(locatorValue);
        else if((locatorType.toLowerCase().equals("classname")))
            return By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("tagname")))
            return By.tagName(locatorValue);
        else if ((locatorType.toLowerCase().equals("linktext")))
            return By.linkText(locatorValue);
        else if ((locatorType.toLowerCase().equals("partiallinktext")))
            return By.partialLinkText(locatorValue);
        else if ((locatorType.toLowerCase().equals("xpath")))
            return By.xpath(locatorValue);
        else if ((locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else {
            throw new Exception("输入的locator type未在程序中定义："+locatorType);
        }
    }

    /**
     * 通过父节点定位一组elements
     * */
    public List<WebElement> elements(WebElement element,By by){
        return element.findElements(by);
    }

    /*
     * 获取文本信息
     * */
    public String getText(WebElement element) {
        return element.getText();
    }

    /**
     * 读取资源文件properties
     * @param propFile
     * @return
     */
    public Properties getPropertiesInstance(String propFile){
        properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(propFile);
            properties.load(in);
            in.close();
        } catch (IOException e) {
            // TODO: handle exception
            LoggerUtil.info("读取对象文件出错");
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 显式等待页面元素加载
     */
    public void waitForPageLoad(By by,int seconds){
        WebDriverWait wait = new WebDriverWait(driverBase.getDriver(), seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * 隐式等待
     * 隐式等待就是针对页面的，显式等待是针对元素的。
     */
    public void waitForPageLoad(int seconds){
        driverBase.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static enum With {
        id,
        xpath,
        name,
        className,
        cssSelector,
        linkText,
        partialLinkText,
        tagName,
    }

    public WebElement getObject(With with,String value){
        WebElement obj=null;
        switch(with){
            case id:
                obj=driverBase.getDriver().findElement(By.id(value));
                break;
            case xpath:
                obj=driverBase.getDriver().findElement(By.xpath(value));
                break;
            case name:
                obj=driverBase.getDriver().findElement(By.name(value));
                break;
            case className:
                obj=driverBase.getDriver().findElement(By.className(value));
                break;
            case cssSelector:
                obj=driverBase.getDriver().findElement(By.cssSelector(value));
                break;
            case linkText:
                obj=driverBase.getDriver().findElement(By.linkText(value));
                break;
            case partialLinkText:
                obj=driverBase.getDriver().findElement(By.partialLinkText(value));
                break;
            case tagName:
                obj=driverBase.getDriver().findElement(By.tagName(value));
                break;
        }
        return obj;
    }



}

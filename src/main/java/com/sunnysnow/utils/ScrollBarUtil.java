package com.sunnysnow.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollBarUtil {

    static WebDriver driver;

    public ScrollBarUtil(DriverBase driverBase){
        this.driver=driverBase.getDriver();
    }

    /**
     * 控制滚动条向下拉到底
     */
    public  void toBottom() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //向下拉到底//
        js.executeScript("document.documentElement.scrollTop=10000");
    }

    /**
     * 控制滚动条向上拉到顶
     */
    public  void toTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //向上拉到顶
        js.executeScript("document.documentElement.scrollTop=0");
    }

    /**
     * 控制滚动条向下拉到底
     */
    public  void scrolltoBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //向下拉到底
        js.executeScript("window.scrollTo(0,100000)");
    }

    /**
     * 控制滚动条向上拉到顶
     */
    public  void scrolltoTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //向上拉到顶
        js.executeScript("window.scrollTo(0,1)");
    }

    /**
     * 控制滚动条拉到中间
     */
    public  void verticaltoMiddle() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //上下拉到中间
        js.executeScript("window.scrollBy(0, 0-document.body.scrollHeight *1/2)");
    }

    /**
     * 控制水平滚动条左右拉到中间
     */
    public  void horizontaltoMiddle() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //左右拉到中间
        js.executeScript("window.scrollBy(0, 0-document.body.scrollWidht *1/2)");
    }

    /**
     * 控制滚动条拉到元素可见
     * @param element 页面元素定位
     */
    public  void scrolltoPresence( WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //移动到元素element对象的“顶端”与当前窗口的“顶部”对齐
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        //移动到元素element对象的“底端”与当前窗口的“底部”对齐
    }

    /**
     * 使用JavaScript的ScrollTo函数
     * 将页面滚动到最下方
     */
    public  void scrollingToBottomofPage(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用JavaScript的ScrollTo函数
     */
    public  void scrollingByCoordinateofPage(){

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

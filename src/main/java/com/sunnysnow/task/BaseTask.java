package com.sunnysnow.task;

import com.sunnysnow.pageObjects.BasePage;
import com.sunnysnow.utils.DriverBase;
import com.sunnysnow.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

/*
    封装页面元素的操作：
    点击、发送值、清空、
 */
public class BaseTask {
    DriverBase driverBase;
    BasePage basePage;

    /**
     * 构造函数
     * @param driverBase
     */
    public BaseTask(DriverBase driverBase) {
        this.driverBase = driverBase;
        basePage= new BasePage(driverBase);
    }

    /**
     * 封装点击方法
     * @param element
     */
    public void click(WebElement element){
        if(element!=null){
            element.click();
        }
        else{
            LoggerUtil.info(element+"元素没有定位到,输入失败");
        }
    }

    /**
     * 封装清空方法
     * @param element
     */
    public void clear(WebElement element){
        if(element!=null){
            element.clear();
        }
        else{
            LoggerUtil.info(element+"元素没有定位到,输入失败");
        }
    }

    /*
     *  @author shao
     * 封装输入方法
     * */
    public void sendKeys(WebElement element,String value) {
        if(element!=null) {
            element.sendKeys(value);
        }else {
            LoggerUtil.info(element+"元素没有定位到,输入失败"+value);
        }
    }

    /*
     * 判断元素是否显示方法
     * */
/*    public boolean assertElementIs(WebElement element) {
        return element.isDisplayed();
    }*/

    /**
     * 鼠标悬停
     * @param element
     */
    public void  MouseOver(WebElement element){
        Actions actions = new Actions(driverBase.getDriver());
        actions.moveToElement(element).perform();;
    }

    /*
     * 返回
     * */
/*    public void back() {
        driverBase.getDriver().navigate().back();
    }*/

    /*
     * 刷新
     * */
/*    public void refresh() {
        driverBase.getDriver().navigate().refresh();;
    }*/

    /**
     * 屏幕最大化
     * */
/*    public void getWindowMax() {
        driverBase.getDriver().manage().window().maximize();
    }*/

    /**
     * @param menuName
     * @param tagName
     * @param elementArray
     */
    public void clickElementArray(String menuName,String tagName,List<WebElement> elementArray){
        List<WebElement> list =elementArray;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getText().equals(menuName)){
                LoggerUtil.info("获取到的菜单名称为："+list.get(i).getText()+":传入的菜单名称为："+menuName);
                click(list.get(i).findElement(By.tagName(tagName)));
                break;
            }
            else if(i==list.size()-1){
                LoggerUtil.info("没有该菜单元素");
                break;
            }
            else{
                continue;
            }
        }
    }

    /**
     * @param tagName
     * @param elementArray
     */
    public void tableElementArray(String str,String tagName,List<WebElement> elementArray){
        List<WebElement> list =elementArray;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getText().equals(str)){
                click(list.get(i).findElement(By.tagName(tagName)));
                break;
            }
            else if(i==list.size()-1){
                LoggerUtil.info("没有该菜单元素");
                break;
            }
            else{
                continue;
            }
        }
    }

    /**
     * action事件
     * */
/*    public void action(WebElement element){
        driverBase.action(element);
    }*/

    /**
     * @author shao
     * 关闭浏览器
     * */
/*    public void close(){
        driverBase.getDriver().close();
    }*/


    /**
     * 获取列表中的行数
     * @param by
     * @return
     */
    public  int GetRowCount( By by) {
        // 获取table元素
        WebElement table = driverBase.getDriver().findElement(by);
        // 获取table表中tr元素集合
        List<WebElement> Rows = table.findElements(By.tagName("tr"));
        // 获取行数
        int RowCount = Rows.size() - 1;
        return RowCount;
    }


    /**
     * 鼠标移动到菜单栏，弹出二级菜单并点击
     * @param actions
     * @param firstmenu
     * @param secondmenu
     * @throws InterruptedException
     */
    public void MoveMouseMenu(Actions actions,String firstmenu, String secondmenu) throws InterruptedException {
        actions = new Actions(driverBase.getDriver());
        actions.moveToElement(driverBase.getDriver().findElement(By.linkText(firstmenu))).perform();
        // JS脚本，点击二级菜单
        WebElement menu = driverBase.getDriver().findElement(By.linkText(secondmenu));
        JavascriptExecutor JS = (JavascriptExecutor) driverBase.getDriver();
        JS.executeScript("arguments[0].click();", menu);
        Thread.sleep(2);
    }

    /**
     * 获取当前窗口所有的windows
     * */
    public List<String> getWindowsHandles(){
        List<String> handles = driverBase.getWindowsHandles();
        return handles;
    }

    /**
     * 根据title切换新窗口
     * */
    public boolean switchToWindow_Title(String windowTitle) {
        boolean flag = false;
        try {
            String currentHandle = driverBase.getDriver().getWindowHandle();
            List<String> handles = driverBase.getWindowsHandles();
            for (String s : handles) {
                if (s.equals(currentHandle))
                    continue;
                else {
                    driverBase.switchWindows(s);
                    if (driverBase.getDriver().getTitle().contains(windowTitle)) {
                        flag = true;
                        System.out.println("切换windows成功: " + windowTitle);
                        break;
                    } else
                        continue;
                }
            }
        } catch (NoSuchWindowException e) {
            System.out.println("Window: " + windowTitle + " 没找到!!!"
                    + e.fillInStackTrace());
            flag = false;
        }
        return flag;
    }


    /*
     * 切换iframe
     * */
    public void getIframe(WebElement element){
        driverBase.getDriver().switchTo().frame(element);
    }

}

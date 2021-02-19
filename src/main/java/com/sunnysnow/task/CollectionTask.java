package com.sunnysnow.task;

import com.sunnysnow.pageObjects.CollectionPage;
import com.sunnysnow.pageObjects.IndexPage;
import com.sunnysnow.utils.DriverBase;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CollectionTask extends BaseTask {
    CollectionPage collectionPage;
    IndexPage indexPage;

    /**
     * 构造函数
     *
     * @param driverBase
     */
    public CollectionTask(DriverBase driverBase) {
        super(driverBase);
        collectionPage = new CollectionPage(driverBase);
        indexPage = new IndexPage(driverBase);
    }

    /**
     * 创建合集
     */
    public String addCollection(String name, String jianjie, String label) {
        String msg = null;
        try {
            //index页面点击合集
            driverBase.sleep(2);
            click(indexPage.getCenterCollectionEle());
            driverBase.sleep(2);
            //点击参加合集按钮
            click(collectionPage.getAddCollBtnEle());
            //选择默认封面
            List<WebElement> picList = collectionPage.getCollPicsEles();
            int picNum = picList.size();
            //int number = (int)(Math.random()*picNum);
            Random df = new Random();
            int number2 = df.nextInt(picNum );
            //获得随机的图片,选取
            WebElement webElement = picList.get(number2);
            click(webElement);
            //输入合集名称
            sendKeys(collectionPage.getCollNameEle(), name);
            //输入合集简介
            sendKeys(collectionPage.getCollJieshaoEle(), jianjie);
            //输入标签
            sendKeys(collectionPage.getCollLabelEle(), label);
            //点击确定按钮
            click(collectionPage.getCollAddBtnEle());
            driverBase.sleep(2);
            //获取创建成功提示
            msg = collectionPage.getText(collectionPage.getCollAddSuccessMsgEle());
            driverBase.sleep(2);
            //点击知道了，关闭弹出框
            click(collectionPage.getCollAddSuccessKnownEle());
            driverBase.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 合集添加文章
     */
    public boolean collAddArticle(String collName){
        int intNum=0;
        int newNum=0;
        int i=0;
        boolean flag=false;
        try {
            List<WebElement> collListName = collectionPage.getCollListNameEle();
            for (WebElement webElement : collListName) {
                if(collName.equals(collectionPage.getText(webElement))){
                    //获得本来合集的文章数量
                    intNum = Integer.parseInt(collectionPage.getText(collectionPage.getCollPartNumEle()));
                    //点击管理按钮
                    click(collectionPage.getCollAddArticelEle());
                    //文复选框控件
                    List<WebElement> collCheckListEles = collectionPage.getCollCheckListEles();
                    for (WebElement check : collCheckListEles) {
                        if(check.isDisplayed()){
                            //添加一篇文章即可
                            click(check);
                            i++;
                            System.out.println(i);
                        }
                    }
                    if(i>0){
                        //点击确定添加
                        click(collectionPage.getCollconfirmBtnEle());
                        driverBase.sleep(2);
                        //获取现有文章数量
                        newNum= Integer.parseInt(collectionPage.getText(collectionPage.getCollPartNumEle()));
                        if(newNum==(intNum+i)){
                            flag=true;
                        }
                    }else {
                        //点击取消按钮
                        click(collectionPage.getCollCancelEle());
                        //获取现有文章数量
                        newNum= Integer.parseInt(collectionPage.getText(collectionPage.getCollPartNumEle()));
                        if(newNum==intNum){
                            flag=true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}

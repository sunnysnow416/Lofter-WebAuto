package com.sunnysnow.task;

import com.sunnysnow.pageObjects.IndexPage;
import com.sunnysnow.utils.DriverBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IndexTask extends BaseTask {
    IndexPage indexPage;

    /**
     * 构造函数
     *
     * @param driverBase
     */
    public IndexTask(DriverBase driverBase) {
        super(driverBase);
        indexPage = new IndexPage(driverBase);
    }

    /**
     * 返回登录用户的用户名称
     *
     * @return
     */
    public String showUser() {
        return indexPage.getText(indexPage.getUserNameEle());
    }

    /**
     * 退出系统
     */
    public void logout() {
        try {
            //点击导航栏-其他
            click(indexPage.getOtherEle());
            //点击退出按钮
            click(indexPage.getLogoutEle());
            //等待
            driverBase.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 发布txt
     */
    public void publishTxt(String title, String content) {
        try{
            writeTxt(title, content);
            driverBase.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void writeTxt(String title, String content) throws Exception {
        //下拉滚动条
        ((JavascriptExecutor) driverBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", indexPage.getTxtEle());
        //1.点击文字
        click( indexPage.getTxtEle());
        driverBase.sleep(3000);
        //2.输入标题
        sendKeys( indexPage.getTxtTitleEle(),title);
        //3.切换iframe
        driverBase.getIframe(indexPage.getIframeEle());
        //输入内容
        sendKeys(indexPage.getTxtContentEle(),content);
        //4.切出ifame
        driverBase.resetIFrame();
    }


    /**
     * 获取提交成功后提示框的文本内容
     *
     * @return
     */
    public String txtSuccessMsg() {
        return indexPage.getText(indexPage.getPublishMsgEle());
    }


    /**
     * 获取待审核的列表条数
     *
     * @return
     */
    public int getAppendTextNum() {
        try {
            List<WebElement> list = indexPage.getTxtPublishListEles();
            return list.size();
        } catch (Exception e) {
            System.out.println("没有此元素");
            return 0;
        }
    }


    /**
     * 取消发布txt
     */
    public void publishTxtCancel(String title, String content) {
        try {
            writeTxt(title, content);
            //点击取消发布按钮
            click( indexPage.getPublishCancelEle());
            driverBase.sleep(3);
            //点击确定按钮
            click(indexPage.getPublishCancelConfirmEle());
            driverBase.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

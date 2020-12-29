package com.sunnysnow.pageObjects;

import com.sunnysnow.utils.DriverBase;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class IndexPage extends BasePage {
    /**
     * 构造函数
     *
     * @param driverBase
     */
    public IndexPage(DriverBase driverBase) {
        super(driverBase);
        bundle = ResourceBundle.getBundle("pageIndex", Locale.CHINA);
    }

    /**
     * 首页显示登录昵称
     *
     * @return
     */
    public WebElement getUserNameEle() {
        WebElement elementObject = null;
        try {
            elementObject = getElementObject("index.username");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementObject;
    }

    /**
     * 首页显示登录昵称
     *
     * @return
     */
    public WebElement getOtherEle() throws Exception {
        return getElementObject("index.others");
    }

    /**
     * 首页显示登录昵称
     *
     * @return
     */
    public WebElement getLogoutEle() throws Exception {
        return getElementObject("index.logout");
    }

    /**
     * 首页-文字
     *
     * @return
     */
    public WebElement getTxtEle() throws Exception {
        return getElementObject("index.text");
    }

    /**
     * 首页-文字-标题
     *
     * @return
     */
    public WebElement getTxtTitleEle() throws Exception {
        return getElementObject("index.text.title");
    }

    /**
     * 首页-iframe
     *
     * @return
     */
    public WebElement getIframeEle() throws Exception {
        return getElementObject("index.text.iframe");
    }

    /**
     * 首页-文字-内容
     *
     * @return
     */
    public WebElement getTxtContentEle() throws Exception {
        return getElementObject("index.text.content");
    }

    /**
     * 首页-发布按钮
     *
     * @return
     */
    public WebElement getPublishEle() throws Exception {
        return getElementObject("index.text.publish");
    }

    /**
     * 首页-发布提示框
     *
     * @return
     */
    public WebElement getPublishMsgEle() {
        WebElement elementObject = null;
        try {
            elementObject = getElementObject("index.text.publishSMsg");
            return elementObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementObject;
    }


    /**
     * 首页-取消发布按钮
     * @return
     */
public WebElement getPublishCancelEle() throws Exception {
        return getElementObject("index.text.cancle");
    }

    /**
     * 首页-取消发布按钮-确定
     * @return
     */
    public WebElement getPublishCancelConfirmEle() throws Exception {
        return getElementObject("index.text.cancle.confirm");
    }


    /**
     * 首页-待审核的文字发布信息列表
     * @return
     */
    public List<WebElement> getTxtPublishListEles() throws Exception {
        return elements("index.text.appendlist");
    }


    /**
     * 首页-预览按钮
     * @return
     */
    public WebElement getPreviewEle() throws Exception {
        return getElementObject("index.text.preview");
    }
}

package com.sunnysnow.pageObjects;

import com.sunnysnow.utils.DriverBase;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class CollectionPage extends BasePage {
    /**
     * 构造函数
     *
     * @param driverBase
     */
    public CollectionPage(DriverBase driverBase) {
        super(driverBase);
        bundle = ResourceBundle.getBundle("pageCollection", Locale.CHINA);
    }

    /**
     * 合集个数文字
     * @return
     */
    public WebElement getCollNumEle() throws Exception {
        return getElementObject("collection.num");
    }

    /**
     * 没有合集文字提示
     * @return
     */
    public WebElement getNOCollNumMsgEle() throws Exception {
        return getElementObject("collection.noCollectionMsg");
    }

    /**
     * 创建合集按钮
     * @return
     */
    public WebElement getAddCollBtnEle() throws Exception {
        return getElementObject("collection.addBtn");
    }


    /**
     * 创建合集-封面图片
     * @return
     */
    public List<WebElement> getCollPicsEles() throws Exception {
        return elements("collection.add.pictures");
    }

    /**
     * 创建合集-名称
     * @return
     */
    public WebElement getCollNameEle() throws Exception {
        return getElementObject("collection.add.name");
    }

    /**
     * 创建合集-简介
     * @return
     */
    public WebElement getCollJieshaoEle() throws Exception {
        return getElementObject("collection.add.jieshao");
    }

    /**
     * 创建合集-简介
     * @return
     */
    public WebElement getCollLabelEle() throws Exception {
        return getElementObject("collection.add.label");
    }

    /**
     * 创建合集-确定按钮
     * @return
     */
    public WebElement getCollAddBtnEle() throws Exception {
        return getElementObject("collection.add.addBtn");
    }

    /**
     * 创建合集-成功提示
     * @return
     */
    public WebElement getCollAddSuccessMsgEle() throws Exception {
        return getElementObject("collection.add.addSuccess");
    }

    /**
     * 创建合集-成功-知道了按钮
     * @return
     */
    public WebElement getCollAddSuccessKnownEle() throws Exception {
        return getElementObject("collection.add.knownBtn");
    }


    /**
     * 创建合集-合集列表
     * @return
     */
    public List<WebElement> getCollListEles() throws Exception {
        return elements("collection.list");
    }

    /**
     * 创建合集-合集列表-管理按钮
     * @return
     */
    public List<WebElement> getCollListManagerEles() throws Exception {
        return elements("collection.list.manager");
    }

    /**
     * 创建合集-合集列表-管理-添加文章
     * @return
     */
    public WebElement getCollAddArticelEle() throws Exception {
        return getElementObject("collection.list.manager.addArticle");
    }

    /**
     * 创建合集-合集列表-添加文章-文章勾选框
     * @return
     */
    public List<WebElement> getCollCheckListEles() throws Exception {
        return elements("collection.list.manager.addArticle.checkList");
    }

    /**
     * 创建合集-合集列表-管理-添加文章-确定按钮
     * @return
     */
    public WebElement getCollconfirmBtnEle() throws Exception {
        return getElementObject("collection.list.manager.addArticle.confirmBtn");
    }

    /**
     * 创建合集-合集列表-管理-添加文章-取消按钮
     * @return
     */
    public WebElement getCollCancelEle() throws Exception {
        return getElementObject("collection.list.manager.addArticle.cancelBtn");
    }

    /**
     * 创建合集-合集列表-管理-添加文章-文章数
     * @return
     */
    public WebElement getCollPartNumEle() throws Exception {
        return getElementObject("collection.part.num");
    }

    /**
     * 创建合集-合集列表-名称
     * @return
     */
    public List<WebElement> getCollListNameEle() throws Exception {
        return elements("collection.list.name");
    }
}

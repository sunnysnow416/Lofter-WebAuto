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


    /**
     * 首页-预览-跳转页面的标题
     * @return
     */
    public WebElement getPublishPreviewTitleEle() throws Exception {
        return getElementObject("index.text.preview.title");
    }


    /**
     * 首页-图片按钮
     * @return
     */
    public WebElement getPicEle() throws Exception {
        return getElementObject("index.picture");
    }

    /**
     * 首页-图片-上传附件
     * @return
     */
    public WebElement getPicUploadEle() throws Exception {
        return getElementObject("index.picture.addfilebtn");
    }


    /**
     * 首页-长文章按钮
     * @return
     */
    public WebElement getArticleBtnEle() throws Exception {
        return getElementObject("index.acticleBtn");
    }


    /**
     * 首页-长文章-上传图片
     * @return
     */
    public WebElement getArticleUploadEle() throws Exception {
        return getElementObject("index.write.uploadpic");
    }

    /**
     * 首页-长文章-标题
     * @return
     */
    public WebElement getArticleTitleEle() throws Exception {
        return getElementObject("index.write.title");
    }

    /**
     * 首页-长文章-发布按钮
     * @return
     */
    public WebElement getArticlePublishEle() throws Exception {
        return getElementObject("index.write.publishBtn");
    }


    /**
     * 首页-长文章-发布-iframe
     * @return
     */
    public WebElement getArticleIframeEle() throws Exception {
        return getElementObject("index.write.publishBtn.iframe");
    }

    /**
     * 首页-长文章-发布-推荐文本框
     * @return
     */
    public WebElement getArticletjEle() throws Exception {
        return getElementObject("index.write.publishBtn.tj");
    }

    /**
     * 首页-长文章-发布-标签
     * @return
     */
    public WebElement getArticleLabelEle() throws Exception {
        return getElementObject("index.write.publishBtn.label");
    }

    /**
     * 首页-长文章-发布成功页面的提示
     * @return
     */
    public WebElement getArticleSuccessMsgEle() throws Exception {
        return getElementObject("index.write.publishBtn.msg");
    }



    /**
     * 首页-音乐按钮
     * @return
     */
    public WebElement getMusicBtnEle() throws Exception {
        return getElementObject("index.music");
    }

    /**
     * 首页-音乐-歌名专辑名艺术家输入框
     * @return
     */
    public WebElement getMusicTxtEle() throws Exception {
        return getElementObject("index.music.name");
    }

    /**
     * 首页-音乐-歌名专辑名艺术家输入-联想内容
     * @return
     */
    public List<WebElement> getMusicEles() throws Exception {
        return elements("index.music.name.more");
    }


    /**
     * 首页-视频按钮
     * @return
     */
    public WebElement getVideoBtnEle() throws Exception {
        return getElementObject("index.video");
    }

    /**
     * 首页-视频-标题
     * @return
     */
    public WebElement getVideoTitleEle() throws Exception {
        return getElementObject("index.video.title");
    }

    /**
     * 首页-视频-关闭
     * @return
     */
    public WebElement getVideoCloseEle() throws Exception {
        return getElementObject("index.video.close");
    }



    /**
     * 首页-创作者中心-文章
     * @return
     */
    public WebElement getCenterArticleEle() throws Exception {
        return getElementObject("index.center.articlelink");
    }

    /**
     * 首页-创作者中心-文章-列表
     * @return
     */
    public List<WebElement> getCenterArticleListEle() throws Exception {
        return elements("index.center.articlelist");
    }



    /**
     * 首页-创作者中心-文章-列表-删除按钮
     * @return
     */
    public List<WebElement> getCenterArticleListDelEle() throws Exception {
        return elements("index.center.article.del");
    }

    /**
     * 首页-创作者中心-文章-没有文字提示语
     * @return
     */
    public WebElement getCenterArticleMsgEle() throws Exception {
        return getElementObject("index.center.article.msg");
    }

    /**
     * 首页-创作者中心-文章-评论按钮
     * @return
     */
    public List<WebElement> getCenterArticlejudgeEle() throws Exception {
        return elements("index.center.article.judge");
    }

    /**
     * 首页-创作者中心-文章-评论文本框
     * @return
     */
    public WebElement getCenterArticlejudgeTxtEle() throws Exception {
        return getElementObject("index.center.article.judegtxt");
    }

    /**
     * 首页-创作者中心-文章-评论发布按钮
     * @returngetPreviewEle
     */
    public WebElement getCenterArticlefbBtnEle() throws Exception {
        return getElementObject("index.center.article.fbBtn");
    }

    /**
     * 首页-创作者中心-文章-列表-评论列表
     * @return
     */
    public List<WebElement> getCenterArticlejudgeListEle() throws Exception {
        return elements("index.center.article.judeglist");
    }

    /**
     * 首页-创作者中心-文章-列表-评论列表
     * @return
     */
    public List<WebElement> getCenterArticlejudgeContentListEle() throws Exception {
        return elements("index.center.article.judeglist.content");
    }

    /**
     * 首页-创作者中心-合集
     * @return
     */
    public WebElement getCenterCollectionEle() throws Exception {
        return getElementObject("index.center.collection");
    }
}

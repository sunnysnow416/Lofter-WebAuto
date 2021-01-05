package com.sunnysnow.task;

import com.sunnysnow.pageObjects.IndexPage;
import com.sunnysnow.utils.DriverBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Set;

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
        try {
            //写内容
            writeTxt(title, content);
            //点击发布按钮
            click(indexPage.getPublishEle());
            driverBase.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeTxt(String title, String content) {
        try {
            //下拉滚动条
            ((JavascriptExecutor) driverBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", indexPage.getTxtEle());
            //1.点击文字
            click(indexPage.getTxtEle());
            driverBase.sleep(3);
            //2.输入标题
            sendKeys(indexPage.getTxtTitleEle(), title);
            //3.切换iframe
            driverBase.getIframe(indexPage.getIframeEle());
            //输入内容
            sendKeys(indexPage.getTxtContentEle(), content);
            //4.切出ifame
            driverBase.resetIFrame();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            click(indexPage.getPublishCancelEle());
            driverBase.sleep(3);
            //点击确定按钮
            click(indexPage.getPublishCancelConfirmEle());
            driverBase.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 预览发布txt
     */
    public String publishTxtPreview(String title, String content) {
        String str = null;
        try {
            writeTxt(title, content);
            //获取当前handle
            String currentHandle = driverBase.getWindowHandle();
            System.out.println("currentHandle:" + currentHandle);
            //点击预览按钮
            click(indexPage.getPreviewEle());
            //切换handle
            List<String> handles = driverBase.getWindowsHandles();
            for (String handle : handles) {
                System.out.println("handle:" + handle);
                if (!handle.equals(currentHandle)) {
                    driverBase.switchWindows(handle);
                }
            }
            //等待
            driverBase.sleep(2);
            str = indexPage.getText(indexPage.getPublishPreviewTitleEle());
            //关闭当前handle
            driverBase.close();
            driverBase.switchWindows(currentHandle);
            System.out.println("关闭新的handle后2:" + driverBase.getWindowHandle());
            //点击发布按钮
            click(indexPage.getPublishEle());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }



    /**
     * 没有上传图片点击发布按钮
     */
    public String publisjPic() {
        String text = null;
        try {
            //下拉滚动条
            ((JavascriptExecutor) driverBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", indexPage.getTxtEle());
            //1.点击图片按钮
            click(indexPage.getPicEle());
            driverBase.sleep(3);
            //点击发布按钮
            click(indexPage.getPublishEle());
            //等待
            driverBase.sleep(1);
            text = indexPage.getText(indexPage.getPublishMsgEle());
            //点击取消按钮
            click(indexPage.getPublishCancelEle());
            driverBase.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }


    /**
     * 没有上传图片点击预览按钮
     */
    public String publishPicPreview() {
        String text = null;
        try {
            //下拉滚动条
            ((JavascriptExecutor) driverBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", indexPage.getTxtEle());
            //1.点击图片按钮
            click(indexPage.getPicEle());
            driverBase.sleep(3);
            //点击发布按钮
            click(indexPage.getPreviewEle());
            //等待
            driverBase.sleep(1);
            text = indexPage.getText(indexPage.getPublishMsgEle());
            //点击取消按钮
            click(indexPage.getPublishCancelEle());
            driverBase.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }


    /**
     * 发布pic
     */
    public void publisjPic(String path, String content) {
        try {
            writePic(path, content);
            //点击发布按钮
            click(indexPage.getPublishEle());
            //等待
            driverBase.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发布图片的具体步骤
     *
     * @param path
     * @param content
     */
    private void writePic(String path, String content) throws Exception {
        //下拉滚动条
        ((JavascriptExecutor) driverBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", indexPage.getTxtEle());
        //1.点击图片按钮
        click(indexPage.getPicEle());
        driverBase.sleep(3);
        //上传单个图片
        uploadFile(indexPage.getPicUploadEle(),path,5);
        //切换iframe
        driverBase.getIframe(indexPage.getIframeEle());
        //输入内容
        sendKeys(indexPage.getTxtContentEle(),content);
        //切出ifame
        driverBase.resetIFrame();
    }



    /**
     * 发布长文章的具体步骤
     *
     * @param path
     * @param title
     * @param content
     * @param label
     * @return
     */
    public String articlePublish(String path, String title, String content, String label) {
        String text = null;
        try {
            //下拉滚动条
            ((JavascriptExecutor) driverBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", indexPage.getTxtEle());
            //获取当前handle
            String currentHandle = driverBase.getWindowHandle();
            System.out.println("currentHandle:" + currentHandle);
            //1.点击长文章按钮
            click(indexPage.getArticleBtnEle());
            driverBase.sleep(3);

            //切换handle
            List<String> handles = driverBase.getWindowsHandles();
            for (String handle : handles) {
                System.out.println("handle:" + handle);
                if (!handle.equals(currentHandle)) {
                    driverBase.switchWindows(handle);
                }
            }

            //点击上传图片
            uploadFile(indexPage.getArticleUploadEle(),path,5);
            //填写标题
            sendKeys( indexPage.getArticleTitleEle(),title);
            //切换iframe
            driverBase.getIframe(indexPage.getIframeEle());
            //输入内容
            sendKeys(indexPage.getTxtContentEle(),content);
            //切出ifame
            driverBase.resetIFrame();
            //点击发布按钮
            click(indexPage.getArticlePublishEle());
            driverBase.sleep(3);
            //切换iframe
            driverBase.getIframe(indexPage.getArticleIframeEle());
            //输入内容
            sendKeys(indexPage.getArticletjEle(),content);
            //切出ifame
            driverBase.resetIFrame();
            driverBase.sleep(2);
            //填写标签
            sendKeys(indexPage.getArticleLabelEle(),label);
            //点击发布按钮
            click( indexPage.getPublishEle());
            driverBase.sleep(5);

            text =indexPage.getText(indexPage.getArticleSuccessMsgEle());
            //关闭当前handle
            driverBase.close();
            driverBase.switchWindows(currentHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }


    /**
     * 不上传音乐发布音乐返回提示
     */
    public String publishMusic() {
        String text = null;
        try {
            writeNoMusic();
            //点击发布按钮
            click(indexPage.getPublishEle());
            //等待
            driverBase.sleep(2);
            text = indexPage.getText(indexPage.getPublishMsgEle());
            driverBase.sleep(2);
            //点击取消按钮
            click(indexPage.getPublishCancelEle());
            driverBase.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 不添加音乐点击发布
     */
    private void writeNoMusic() throws Exception {
        //下拉滚动条
        ((JavascriptExecutor) driverBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", indexPage.getTxtEle());
        //1.点击音乐按钮
        click(indexPage.getMusicBtnEle());
        driverBase.sleep(2);
    }


    /**
     * 没有上传音乐点击预览按钮
     */
    public String publishMusicPreview() {
        String text = null;
        try {
            writeNoMusic();
            //点击预览按钮
            click(indexPage.getPreviewEle());
            //等待
            driverBase.sleep(1);
            text = indexPage.getText(indexPage.getPublishMsgEle());
            //点击取消按钮
            click(indexPage.getPublishCancelEle());
            driverBase.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 发布音乐
     */
    public void publishMusic(String name, String content) {
        try {
            writeMusic(name, content);
            //5.点击发布按钮
            click( indexPage.getPublishEle());
            driverBase.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发布音乐的具体步骤
     *
     * @param name
     */
    private void writeMusic(String name, String content) throws Exception {
        //下拉滚动条
        ((JavascriptExecutor) driverBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", indexPage.getTxtEle());
        //1.点击音乐按钮
        click(indexPage.getMusicBtnEle());
        driverBase.sleep(2);
        //输入名字或专辑名等
        sendKeys(indexPage.getMusicTxtEle(),name);
        driverBase.sleep(2);
        List<WebElement> list = indexPage.getMusicEles();
        //如果有记录就选第一条
        if (list.size() > 0) {
            list.get(0).click();
            Thread.sleep(2000);
        }
        //切换iframe
        driverBase.getIframe(indexPage.getIframeEle());
        //输入内容
        sendKeys( indexPage.getTxtContentEle(),content);
        //切出ifame
        driverBase.resetIFrame();
    }

    /**
     * 发布视频
     */
    public String publishVideo() {
        String text = null;
        try {
            //下拉滚动条
            ((JavascriptExecutor) driverBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", indexPage.getTxtEle());
            //1.点击音乐按钮
            click(indexPage.getVideoBtnEle());
            driverBase.sleep(2);
            text =indexPage.getText(indexPage.getVideoTitleEle());
            //6.等待
            driverBase.sleep(2);
            click(indexPage.getVideoCloseEle());
            driverBase.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 删除文章
     */
    public String delArticles() {
        String text=null;
        try {
            //点击文章列表
            click(indexPage.getCenterArticleEle());
            driverBase.sleep(2);
            //获得列表
            List<WebElement> list = indexPage.getCenterArticleListEle();
            System.out.println("共有文章数量："+list.size());
            //获取删除按钮
            List<WebElement> delList = indexPage.getCenterArticleListDelEle();
            for (WebElement webElement : delList) {
                click(webElement);
                //弹出框点击确定按钮
                click( indexPage.getPublishCancelConfirmEle());
                driverBase.sleep(2);
            }
            text = indexPage.getText(indexPage.getCenterArticleMsgEle());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 评论文章
     */
    public boolean judgeArticles(String msg) {
        boolean flag=false;
        try {
            //点击文章列表
            click(indexPage.getCenterArticleEle());
            driverBase.sleep(2);
            //获得列表
            List<WebElement> list = indexPage.getCenterArticleListEle();
            System.out.println("共有文章数量："+list.size());
            //获取评论按钮
            List<WebElement> judgeList = indexPage.getCenterArticlejudgeEle();
            //取第一个文章
            WebElement webElement = judgeList.get(0);
            driverBase.sleep(2);
            click(webElement);
            sendKeys(indexPage.getCenterArticlejudgeTxtEle(),msg);
            //点击发布按钮
            click(indexPage.getCenterArticlefbBtnEle());
            driverBase.sleep(2);
            //评论列表
            List<WebElement> plList = indexPage.getCenterArticlejudgeContentListEle();
            for (WebElement element : plList) {
                System.out.println("元素："+element.getText());
                if(element.getText().equals(msg)){
                    flag=true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}

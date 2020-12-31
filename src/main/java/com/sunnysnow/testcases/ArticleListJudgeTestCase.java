package com.sunnysnow.testcases;

import com.sunnysnow.task.IndexTask;
import com.sunnysnow.utils.CommUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArticleListJudgeTestCase extends BaseCase {
    IndexTask indexTask;

    /**
     * 文字发布成功
     */
    @Test(description = "成功发布文本")
    public void txtPublishsuccessTest(){
        indexTask = new IndexTask(driverBase);
        String title="我的测试标题"+ CommUtil.getCurrentSysTime();
        String content="我的测试正文"+CommUtil.getCurrentSysTime();
        indexTask.publishTxt(title,content);
        Assert.assertEquals(indexTask.txtSuccessMsg(),"发布成功，动态审核中");
    }

    /**
     * 评论文章
     */
    @Test(description = "成功评论文章",dependsOnMethods = "txtPublishsuccessTest")
    public void delArticleTest(){
        String content="我的评论"+CommUtil.getCurrentSysTime();
        boolean result = indexTask.judgeArticles(content);
        Assert.assertEquals(result,true);
    }
}

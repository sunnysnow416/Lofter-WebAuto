package com.sunnysnow.testcases;

import com.sunnysnow.task.IndexTask;
import com.sunnysnow.utils.Assertion;
import com.sunnysnow.utils.CommUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArticleListDelTestCase extends BaseCase {
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
        //Assert.assertEquals(indexTask.txtSuccessMsg(),"发布成功，动态审核中");
        Assertion.verifyEquals(indexTask.txtSuccessMsg(),"发布成功，动态审核中");
    }

    /**
     * 删除文章
     */
    @Test(description = "成功删除文章",dependsOnMethods = "txtPublishsuccessTest")
    public void delArticleTest(){
        String result = indexTask.delArticles();
        //Assert.assertEquals(result,"没有文章");
        Assertion.verifyEquals(result,"没有文章");
    }
}

package com.sunnysnow.testcases;

import com.sunnysnow.task.IndexTask;
import com.sunnysnow.utils.Assertion;
import com.sunnysnow.utils.CommUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArticleTestCase extends BaseCase {
    IndexTask indexTask;


    @Test(description = "长文章发布成功")
    public void articlePublishTest(){
        indexTask = new IndexTask(driverBase);
        String path=this.getClass().getResource("/files/uploadFile.exe").getPath();
        String title="长文章标题"+ CommUtil.getCurrentSysTime();
        String content="长文章正文"+ CommUtil.getCurrentSysTime();
        String label="标签"+ CommUtil.getCurrentSysTime();

        String restult = indexTask.articlePublish(path, title, content, label);
        //Assert.assertEquals( restult,"文章发布成功！");
        Assertion.verifyEquals(restult,"文章发布成功！");
    }
}

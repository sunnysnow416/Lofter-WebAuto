package com.sunnysnow.testcases;

import com.sunnysnow.task.IndexTask;
import com.sunnysnow.utils.CommUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PicTestCase extends BaseCase {
    IndexTask indexTask;

    /**
     * 不上传图片发布失败，有提示语
     */
    @Test(description = "不上传图片发布失败，有提示语",enabled = true)
    public void noPicPublishTest(){
        indexTask = new IndexTask(driverBase);
        String result = indexTask.publisjPic();
        Assert.assertEquals(result,"您还没有添加任何图片！");
    }

    /**
     * 不上传图片预览失败，有提示语
     */
    @Test(description = "不上传图片预览失败，有提示语",enabled = true)
    public void noPicPreviewTest(){
        indexTask = new IndexTask(driverBase);
        String result = indexTask.publishPicPreview();
        Assert.assertEquals(result,"您还没有添加任何图片！");
    }

    /**
     * 图片发布成功
     */
    @Test(description = "成功发布图片")
    public void picPublishsuccessTest(){
        indexTask = new IndexTask(driverBase);
        String path = this.getClass().getResource("/files/uploadFile.exe").getPath();
        System.out.println("path:"+path);
        String content="图片测试正文"+ CommUtil.getCurrentSysTime();

        indexTask.publisjPic(path,content);
        Assert.assertEquals(indexTask.txtSuccessMsg(),"发布成功，动态审核中");
    }
}

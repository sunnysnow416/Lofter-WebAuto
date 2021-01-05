package com.sunnysnow.testcases;

import com.sunnysnow.task.IndexTask;
import com.sunnysnow.utils.Assertion;
import com.sunnysnow.utils.CommUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MusicTestCase extends BaseCase{
    IndexTask indexTask;

    /**
     * 不添加音乐发布提示请添加音乐
     */
    @Test(description = "发布音乐提示请添加音乐")
    public void noMusicPublishTest(){
        indexTask = new IndexTask(driverBase);
        String result = indexTask.publishMusic();
        //Assert.assertEquals(result,"请添加音乐！");
        Assertion.verifyEquals(result,"请添加音乐！");
    }

    /**
     * 不添加音乐预览提示请添加音乐
     */
    @Test(description = "发布音乐提示请添加音乐")
    public void noMusicPreviewTest(){
        indexTask = new IndexTask(driverBase);
        String result = indexTask.publishMusicPreview();
        //Assert.assertEquals(result,"请添加音乐！");
        Assertion.verifyEquals(result,"请添加音乐！");
    }

    /**
     * 不添加音乐提示请添加音乐
     */
    @Test(description = "成功发布音乐")
    public void musicPublishsuccessTest(){
        indexTask = new IndexTask(driverBase);
        String name="许巍";
        String content="音乐测试正文"+ CommUtil.getCurrentSysTime();

        indexTask.publishMusic(name,content);
        //Assert.assertEquals(indexTask.txtSuccessMsg(),"发布成功，动态审核中");
        Assertion.verifyEquals(indexTask.txtSuccessMsg(),"发布成功，动态审核中");
    }
}

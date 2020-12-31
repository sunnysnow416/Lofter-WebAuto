package com.sunnysnow.testcases;

import com.sunnysnow.task.IndexTask;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VideoTestCase extends BaseCase{
    IndexTask indexTask;

    /**
     * 上传视频
     */
    @Test(description = "发布视频")
    public void viedoPublishTest(){
        indexTask = new IndexTask(driverBase);
        String result = indexTask.publishVideo();
        Assert.assertEquals( result,"请前往手机版LOFTER客户端上传视频");
    }
}

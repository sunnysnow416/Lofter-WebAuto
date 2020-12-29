package com.sunnysnow.testcases;

import com.sunnysnow.task.IndexTask;
import com.sunnysnow.utils.CommUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextTestCase extends  BaseCase {
    IndexTask indexTask;

    @Test(description = "文字发布成功")
    public void txtPublishsuccessTest(){
        indexTask = new IndexTask(driverBase);
        String title="我的测试标题"+ CommUtil.getCurrentSysTime();
        String content="我的测试正文"+CommUtil.getCurrentSysTime();

        indexTask.publishTxt(title,content);
        Assert.assertEquals(indexTask.txtSuccessMsg(),"发布成功，动态审核中");
    }



    /**
     * 取消文字发布成功
     */
    @Test(description = "取消文字发布")
    public void txtPublishCancelTest(){
        String title="我的测试标题"+ CommUtil.getCurrentSysTime();
        String content="我的测试正文"+CommUtil.getCurrentSysTime();

        int first = indexTask.getAppendTextNum();
        System.out.println("发布前待发布的数量为："+first);
        indexTask.publishTxtCancel(title,content);
        int second = indexTask.getAppendTextNum();
        System.out.println("取消新的发布后待发布的数量为："+second);
        Assert.assertEquals(first,second);
    }
}

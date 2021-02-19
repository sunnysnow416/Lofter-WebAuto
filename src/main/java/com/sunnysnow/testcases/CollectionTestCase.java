package com.sunnysnow.testcases;

import com.sunnysnow.task.CollectionTask;
import com.sunnysnow.utils.Assertion;
import com.sunnysnow.utils.CommUtil;
import org.testng.annotations.Test;

public class CollectionTestCase  extends BaseCase{
    CollectionTask collectionTask;
    String name;

    @Test(description = "创建合集成功")
    public void addCollsuccessTest(){
        collectionTask =new CollectionTask(driverBase);
        name="名"+ CommUtil.getCurrentSysTime();
        String jianjie="合集简介"+CommUtil.getCurrentSysTime();
        String label="合集标签"+CommUtil.getCurrentSysTime();
        String result = collectionTask.addCollection(name, jianjie, label);
        Assertion.verifyEquals(result,"合集创建成功！");
    }

    @Test(description = "合集添加文章成功",dependsOnMethods = "addCollsuccessTest")
    public void delCollcessTest(){
        collectionTask =new CollectionTask(driverBase);
        boolean result = collectionTask.collAddArticle(name);
        Assertion.verifyEquals(result,true);
    }

}

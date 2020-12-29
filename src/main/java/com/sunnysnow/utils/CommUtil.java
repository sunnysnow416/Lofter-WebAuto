package com.sunnysnow.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommUtil {

    /**
     * 获取当前系统时间格式为yyyyMMddHHmmss
     * @return
     */
    public static String getCurrentSysTime() {
        Date currentTime = new Date();
        // 日期格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        // 获取系统当前时间
        String dateStr = formatter.format(currentTime);
        return dateStr;
    }
}

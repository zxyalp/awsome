package com.howbuy.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author yang.zhou
 * @date 2017/12/18
 */
public class DateUtils {

    private final Logger logger = LoggerFactory.getLogger(DateUtils.class.getName());

    private static DateUtils dateUtils = null;

    private DateUtils() {

    }

    public static DateUtils getInstance() {
        if (dateUtils == null) {
            synchronized (DateUtils.class) {
                if (dateUtils == null) {
                    dateUtils = new DateUtils();
                }
            }
        }
        return dateUtils;
    }

    public static String getNowDate() {
        return getUserDate("yyyy-MM-dd");
    }

    public static String getNowTime() {
        return getUserDate("HHmmss");
    }

    public static String getUserDate(String format) {
        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(currentTime);
    }

}

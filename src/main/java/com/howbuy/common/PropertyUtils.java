package com.howbuy.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 读取property文件工具类
 *
 * @author summe
 * @date 2017/12/17
 */
public class PropertyUtils {

    private static final Logger logger = LoggerFactory.getLogger(PropertyUtils.class.getName());

    private static Properties props;

    private PropertyUtils() {

    }

    static {
        load();
    }

    private synchronized static void load() {
        logger.info("properties loading....");
        props = new Properties();
        InputStream in = null;
        try {
            in = PropertyUtils.class.getClassLoader().getResourceAsStream("config.properties");
            props.load(in);
            logger.info("加载properties文件完成");
            logger.info("文件内容：{}", props);
        } catch (IOException i) {
            logger.error("{}", i);
        } catch (Exception e) {
            logger.error("加载配置文件异常", e);
            throw new RuntimeException("加载config.properties配置文件异常.");
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("IO错误.", e);
                }
            }
        }
    }

    public static String getProperty(String key, String defaultValue) {
        if (props == null) {
            load();
        }

        return props.getProperty(key, defaultValue);
    }

    public static String getProperty(String key) {
        if (props == null) {
            load();
        }
        return props.getProperty(key);
    }


    public static void getAllProperty() {
        if (props == null) {
            load();
        }

        StringBuilder stringBuilder = new StringBuilder("获取config.property文件全部信息.\n");

        Set<Map.Entry<Object, Object>> entries = props.entrySet();

        for (Map.Entry<Object, Object> entry : entries) {
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
        }

        logger.info(stringBuilder.toString());
    }

}

package com.howbuy.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.client.utils.URIBuilder;


/**
 * @author summe
 * @date 2018/1/14
 */
public class UrlBuilder extends URIBuilder {

    private final Logger logger = LoggerFactory.getLogger(UrlBuilder.class.getName());

    private static String host = PropertyUtils.getProperty("http.host");


    public UrlBuilder create() {
        super.setScheme("http");
        if (StringUtils.isBlank(host)) {
            throw new RuntimeException("您还未设置host值，请在conf.properties文件中设置http.host值.");
        }
        super.setHost(host);
        if (getPort() == -1) {
            setPort(1508);
        }
        return this;
    }

    public UrlBuilder setPortPath(int port, String path) {
        super.setPort(port);
        super.setPath(path);
        return this;
    }

}

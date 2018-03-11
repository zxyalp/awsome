package com.whatapp;


import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * test
 */
public class Demo {

    public static void main(String[] args) {

        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setHost("192.168.221.216");
        builder.setPort(1508);
        builder.setPort(1500);
        List<NameValuePair> name = new ArrayList<>();
        name.add(new BasicNameValuePair("name", "zhouyanng"));
        name.add(new BasicNameValuePair("age", "18"));
        builder.setParameters(name);
        builder.addParameters(name);
        builder.setPath("/bajns/eushu9/eeyiu");
        System.out.println(builder.getPort());
        System.out.println(builder.toString());

    }
}

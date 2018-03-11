package com.whatapp;

import com.howbuy.common.PropertyUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws MalformedURLException {

        doGet01();

    }


    public static void doGet() {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpGet httpGet = new HttpGet("http://192.168.221.123:15080/trade/captcha.htm?t=1515562467630");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/60.0.3112.113 Safari/537.36");

            CloseableHttpResponse response1 = httpClient.execute(httpGet);

            HttpEntity entity = response1.getEntity();

            String content = EntityUtils.toString(entity, "utf-8");

            System.out.println(content);

            System.out.println("-----------------------");

            String server = response1.getFirstHeader("Server").toString();

            System.out.println(server);

            System.out.println("========================");
            Header[] headers = response1.getAllHeaders();

            for (Header header : headers) {
                System.out.println(header.toString());
            }

            System.out.println("---------------------");

            EntityUtils.consume(entity);

        } catch (ClientProtocolException c) {
            c.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void doGet01() {

        File file = new File("D://data//1.jpeg");

        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpHost httpHost = new HttpHost("127.0.0.1", 8888, "http");

        RequestConfig config = RequestConfig.custom().setProxy(httpHost).build();

        try {

            HttpGet httpGet = new HttpGet("http://192.168.221.123:15080/trade/captcha.htm?t=1515562467630");
            httpGet.setConfig(config);
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) Chrome/60.0.3112.113 Safari/537.36");

            CloseableHttpResponse response1 = httpClient.execute(httpGet);

            HttpEntity entity = response1.getEntity();

            InputStream stream = entity.getContent();

            in = new BufferedInputStream(stream);

            out = new BufferedOutputStream(new FileOutputStream(file));

            int len;

            byte[] size = new byte[1024];

            while ((len = in.read(size)) != -1) {
                out.write(size, 0, len);
            }


            EntityUtils.consume(entity);

        } catch (ClientProtocolException c) {
            c.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

package com.caitiezhu.gaea.gitlab.http;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class DefaultHttpClient {

    public static HttpResponse doPost(String url, List<NameValuePair> parameters) throws IOException {
        // 创建 httpclient 对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        // 创建 post 请求
        HttpPost postMethod = new HttpPost(url);
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        postMethod.setEntity(formEntity);

        String respMessage = null;
        int statusCode;
        try {
            response = httpclient.execute(postMethod);
            statusCode = response.getStatusLine().getStatusCode();
            respMessage = EntityUtils.toString(response.getEntity(), "UTF-8");
        } finally {
            if (response != null) response.close();
            httpclient.close();
        }
        return new HttpResponse(statusCode, respMessage);
    }

    public static HttpResponse doPost(String url) throws IOException {
        // 创建 httpclient 对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        // 创建 post 请求
        HttpPost postMethod = new HttpPost(url);

        String respMessage = null;
        int statusCode;
        try {
            response = httpclient.execute(postMethod);
            statusCode = response.getStatusLine().getStatusCode();
            respMessage = EntityUtils.toString(response.getEntity(), "UTF-8");
        } finally {
            if (response != null) response.close();
            httpclient.close();
        }
        return new HttpResponse(statusCode, respMessage);
    }

    public static HttpResponse doGet(String url, List<NameValuePair> parameters) throws URISyntaxException, IOException {
        // 创建 httpclient 对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        // 定义请求的参数
        URI uri = new URIBuilder(url).addParameters(parameters).build();
        // 创建http GET请求
        HttpGet getMethod = new HttpGet(uri);

        String respMessage = null;
        int statusCode;
        try {
            response = httpclient.execute(getMethod);
            statusCode = response.getStatusLine().getStatusCode();
            respMessage = EntityUtils.toString(response.getEntity(), "UTF-8");
        } finally {
            if (response != null) response.close();
            httpclient.close();
        }
        return new HttpResponse(statusCode, respMessage);
    }

    public static HttpResponse doGet(String url) throws URISyntaxException, IOException {
        // 创建 httpclient 对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        // 创建http GET请求
        HttpGet getMethod = new HttpGet(url);

        String respMessage = null;
        int statusCode;
        try {
            response = httpclient.execute(getMethod);
            statusCode = response.getStatusLine().getStatusCode();
            respMessage = EntityUtils.toString(response.getEntity(), "UTF-8");
        } finally {
            if (response != null) response.close();
            httpclient.close();
        }
        return new HttpResponse(statusCode, respMessage);
    }
}

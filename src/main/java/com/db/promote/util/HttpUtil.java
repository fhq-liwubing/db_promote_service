package com.db.promote.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by weijianglong on 2015/9/13.
 */
@Slf4j
public class HttpUtil {

    public static String get(String url) {
        return get(url, null);
    }

    public static String get(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            if (MapUtils.isNotEmpty(params)) {
                if (!url.contains("?")) {
                    url += "?";
                }

                if (!url.endsWith("&") && !url.endsWith("?")) {
                    url += "&";
                }

                for (Map.Entry<String, String> entry : params.entrySet()) {
                    url += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "GBK") + "&";
                }
            }

            HttpGet httpGet = new HttpGet(url);

            log.info("[HttpUtil]request sent, method=GET, url=" + url);

            long start = System.currentTimeMillis();

            response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();

            long cost = System.currentTimeMillis() - start;

            String result = EntityUtils.toString(responseEntity);

            log.info("[HttpUtil]response received, method=GET, cost=" + cost + ", result=" + result);

            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute the http request, url: " + url, e);
        } finally {
            try {
                httpClient.close();

                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
            }
        }
    }

    /**
     * 发起post请求
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String post(String url, Map<String, String> params) {
        return post(url, params, null);
    }

    /**
     * 发起post请求
     *
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws Exception
     */
    public static String post(String url, Map<String, String> params, Map<String, String> headers) {
        log.info("[HttpUtil]request sent, method=POST, url=" + url + ", param=" + params);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            HttpPost httpPost = new HttpPost(url);
            if (MapUtils.isNotEmpty(headers)) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }

            List<NameValuePair> httpParams = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                httpParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(httpParams, "GBK"));

            long start = System.currentTimeMillis();

            //避免出现超时，如果不配置，httpClient4.3以后默认>24小时
            httpPost.setConfig(getReqeustConfig());
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();

            long cost = System.currentTimeMillis() - start;

            String result = EntityUtils.toString(responseEntity, "utf-8");

            log.info("[HttpUtil]response received, method=POST, cost=" + cost + ", url=" + url + ", response=" +
                    result);

            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute the http request, url: " + url, e);
        } finally {
            try {
                httpClient.close();

                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
            }
        }
    }
    
    
    public static String post(String url, String content, String contentType) {
        log.info("[HttpUtil]request sent, method=POST, url=" + url + ", content=" + content);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity se = new StringEntity(content, "UTF-8");
			se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, contentType));
			se.setContentEncoding("UTF-8");
			httpPost.setEntity(se);

            long start = System.currentTimeMillis();

            //避免出现超时，如果不配置，httpClient4.3以后默认>24小时
            httpPost.setConfig(getReqeustConfig());
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();

            long cost = System.currentTimeMillis() - start;

            String result = EntityUtils.toString(responseEntity);

            log.info("[HttpUtil]response received, method=POST, cost=" + cost + ", url=" + url + ", response=" +
                    result);

            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute the http request, url: " + url, e);
        } finally {
            try {
                httpClient.close();

                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
            }
        }
    }


    public static void openUrl(String url){

        String cmd = "cmd.exe /c start " + url;

        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            proc.waitFor();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取HTTP请求的配置
     * @return
     */
	private static RequestConfig getReqeustConfig() {
		Integer timeout = 60000;
		//logger.info("Timeout time is:" + timeout);
		//1.ConnectionRequestTimeout: 经历多久之后，这次请求被视为过期 
		//2.ConnectTimeout: 等待与服务器建立连接的时间 
		//3.SocketTimeout: 与服务器的连接建立了，等待服务器发送数据的时间
		RequestConfig requstConfigure = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
		return requstConfigure;
	}
}

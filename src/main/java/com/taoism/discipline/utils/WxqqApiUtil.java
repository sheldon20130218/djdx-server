package com.taoism.discipline.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.alibaba.fastjson.JSONObject;
import com.taoism.discipline.model.VxapiVerificationInfo;

public class WxqqApiUtil {

	private final static String APPID = PropertiesUtil.getValue("APPID");
	
	private final static String SECRET=PropertiesUtil.getValue("SECRET");
	
	public static VxapiVerificationInfo getVxapiVerificationInfo(String code) {
		VxapiVerificationInfo vInfo = new VxapiVerificationInfo();
		String getOpenIDUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + SECRET + "&js_code=" + code + "&grant_type=authorization_code";
		JSONObject openIDJO = doGetRequest(getOpenIDUrl);
		if(!openIDJO.containsKey("openid")) {
			return vInfo;
		}
		
        String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?appid=" + APPID + "&secret=" + SECRET + "&grant_type=client_credential";
        JSONObject tokenJO = doGetRequest(getTokenUrl);
        
        
        vInfo.setAccess_token(tokenJO.getString("access_token"));
        vInfo.setOpenid(openIDJO.getString("openid"));
        vInfo.setSession_key(openIDJO.getString("session_key"));
        return vInfo; 
	}
	
	
	private static JSONObject doGetRequest(String url) {
        JSONObject jo = new JSONObject();
        //1.生成HttpClient对象并设置参数
        HttpClient httpClient = new HttpClient();
        //设置Http连接超时为5秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);

        //2.生成GetMethod对象并设置参数
        GetMethod getMethod = new GetMethod(url);
        //设置get请求超时为5秒
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        //设置请求重试处理，用的是默认的重试处理：请求三次
//        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

        try {
            //3.执行HTTP GET 请求
            int statusCode = httpClient.executeMethod(getMethod);

            //4.判断访问的状态码
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("请求出错：" + getMethod.getStatusLine());
            }

            //5.处理HTTP响应内容
            //读取HTTP响应内容，这里简单打印网页内容
            //读取为字节数组
            byte[] responseBody = getMethod.getResponseBody();
            jo = JSONObject.parseObject(new String(responseBody, "UTF-8"));
            System.out.println("-----------response:" + jo);
            //读取为InputStream，在网页内容数据量大时候推荐使用
            //InputStream response = getMethod.getResponseBodyAsStream();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.释放连接
            getMethod.releaseConnection();
        }
        return jo;
    }
}

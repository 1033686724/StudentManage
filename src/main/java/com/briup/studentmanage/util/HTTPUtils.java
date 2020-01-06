package com.briup.studentmanage.util;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
public class HTTPUtils {
 
	private final static Logger logger = Logger.getLogger(HTTPUtils.class);
 
	private final static String OPERATER_NAME = "【HTTP操作】";
 
	private final static int SUCCESS = 200;
 
	private final static String UTF8 = "UTF-8";
 
	private HttpClient client;
 
	private static HTTPUtils instance = new HTTPUtils();
 
	/**
	 * 私有化构造器
	 */
	private HTTPUtils() {
 
		HttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams params = httpConnectionManager.getParams();
		params.setConnectionTimeout(5000);
		params.setSoTimeout(20000);
		params.setDefaultMaxConnectionsPerHost(1000);
		params.setMaxTotalConnections(1000);
		client = new HttpClient(httpConnectionManager);
		client.getParams().setContentCharset(UTF8);
		client.getParams().setHttpElementCharset(UTF8);
	}
 
	/**
	 * get请求
	 */
	public static String get(URL url) {
		return instance.doGet(url);
	}
 
	private String doGet(URL url) {
		long beginTime = System.currentTimeMillis();
		String respStr = StringUtils.EMPTY;
		try {
			logger.info(OPERATER_NAME + "开始get通信，目标host:" + url);
			HttpMethod method = new GetMethod(url.toString());
			// ����ת��
			method.getParams().setContentCharset(UTF8);
			try {
				client.executeMethod(method);
			} catch (HttpException e) {
 
				logger.error(new StringBuffer("发送HTTP GET给\r\n").append(url).append("\r\nHTTP异常\r\n"), e);
			} catch (IOException e) {
 
				logger.error(new StringBuffer("发送HTTP GET给\r\n").append(url).append("\r\nIO异常\r\n"), e);
			}
			if (method.getStatusCode() == SUCCESS) {
				respStr = method.getResponseBodyAsString();
			}
			// �ͷ�����
			method.releaseConnection();
 
			logger.info(OPERATER_NAME + "通讯完成 返回码" + method.getStatusCode());
			logger.info(OPERATER_NAME + "通讯内容" + method.getResponseBodyAsString());
			logger.info(OPERATER_NAME + "结果..返回结果:" + respStr);
		} catch (Exception e) {
			logger.info(OPERATER_NAME, e);
		}
		long endTime = System.currentTimeMillis();
		logger.info(OPERATER_NAME + "共计耗时:" + (endTime - beginTime) + "ms");
 
		return respStr;
	}
 
	/**
	 * POST请求
	 */
	public static String post(URL url, String content) {
		return instance.doPost(url, content);
	}
 
	private String doPost(URL url, String content) {
		long beginTime = System.currentTimeMillis();
		String respStr = StringUtils.EMPTY;
		try {
			logger.info(OPERATER_NAME + "开始post通信，目标host:" + url.toString());
			logger.info("通信内容:" + content);
			PostMethod post = new PostMethod(url.toString());
			RequestEntity requestEntity = new StringRequestEntity(content, "application/json", UTF8);
			post.setRequestEntity(requestEntity);
			// ���ø�ʽ
			post.getParams().setContentCharset(UTF8);
 
			client.executeMethod(post);
			if (post.getStatusCode() == SUCCESS) {
				respStr = post.getResponseBodyAsString();
			}
 
			logger.info(OPERATER_NAME + "通讯完成，返回码" + post.getStatusCode());
			logger.info(OPERATER_NAME + "返回内容" + post.getResponseBodyAsString());
			logger.info(OPERATER_NAME + "结果..返回结果:" + respStr);
			post.releaseConnection();
 
		} catch (Exception e) {
			logger.error(OPERATER_NAME, e);
		}
		long endTime = System.currentTimeMillis();
		logger.info(OPERATER_NAME + "共计耗时ʱ:" + (endTime - beginTime) + "ms");
		return respStr;
	}
 
}
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
 
	private final static String OPERATER_NAME = "��HTTP������";
 
	private final static int SUCCESS = 200;
 
	private final static String UTF8 = "UTF-8";
 
	private HttpClient client;
 
	private static HTTPUtils instance = new HTTPUtils();
 
	/**
	 * ˽�л�������
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
	 * get����
	 */
	public static String get(URL url) {
		return instance.doGet(url);
	}
 
	private String doGet(URL url) {
		long beginTime = System.currentTimeMillis();
		String respStr = StringUtils.EMPTY;
		try {
			logger.info(OPERATER_NAME + "��ʼgetͨ�ţ�Ŀ��host:" + url);
			HttpMethod method = new GetMethod(url.toString());
			// ����ת��
			method.getParams().setContentCharset(UTF8);
			try {
				client.executeMethod(method);
			} catch (HttpException e) {
 
				logger.error(new StringBuffer("����HTTP GET��\r\n").append(url).append("\r\nHTTP�쳣\r\n"), e);
			} catch (IOException e) {
 
				logger.error(new StringBuffer("����HTTP GET��\r\n").append(url).append("\r\nIO�쳣\r\n"), e);
			}
			if (method.getStatusCode() == SUCCESS) {
				respStr = method.getResponseBodyAsString();
			}
			// �ͷ�����
			method.releaseConnection();
 
			logger.info(OPERATER_NAME + "ͨѶ��ɣ������룺" + method.getStatusCode());
			logger.info(OPERATER_NAME + "�������ݣ�" + method.getResponseBodyAsString());
			logger.info(OPERATER_NAME + "����..���ؽ��:" + respStr);
		} catch (Exception e) {
			logger.info(OPERATER_NAME, e);
		}
		long endTime = System.currentTimeMillis();
		logger.info(OPERATER_NAME + "���ƺ�ʱ:" + (endTime - beginTime) + "ms");
 
		return respStr;
	}
 
	/**
	 * POST����
	 */
	public static String post(URL url, String content) {
		return instance.doPost(url, content);
	}
 
	private String doPost(URL url, String content) {
		long beginTime = System.currentTimeMillis();
		String respStr = StringUtils.EMPTY;
		try {
			logger.info(OPERATER_NAME + "��ʼpostͨ�ţ�Ŀ��host:" + url.toString());
			logger.info("ͨ������:" + content);
			PostMethod post = new PostMethod(url.toString());
			RequestEntity requestEntity = new StringRequestEntity(content, "application/json", UTF8);
			post.setRequestEntity(requestEntity);
			// ���ø�ʽ
			post.getParams().setContentCharset(UTF8);
 
			client.executeMethod(post);
			if (post.getStatusCode() == SUCCESS) {
				respStr = post.getResponseBodyAsString();
			}
 
			logger.info(OPERATER_NAME + "ͨѶ��ɣ������룺" + post.getStatusCode());
			logger.info(OPERATER_NAME + "�������ݣ�" + post.getResponseBodyAsString());
			logger.info(OPERATER_NAME + "����..���ؽ��:" + respStr);
			post.releaseConnection();
 
		} catch (Exception e) {
			logger.error(OPERATER_NAME, e);
		}
		long endTime = System.currentTimeMillis();
		logger.info(OPERATER_NAME + "���ƺ�ʱ:" + (endTime - beginTime) + "ms");
		return respStr;
	}
 
}
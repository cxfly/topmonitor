package com.ali.lp.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ali.lp.log.service.ApiInvokeLogSaveHandler;

//接口调用日志异步保存线程
public class ApiInvokeLogSaveThread implements Runnable {
	private static final Logger logger = LoggerFactory
			.getLogger(ApiInvokeLogSaveThread.class);

	private ApiInvokeLogSaveHandler apiInvokeLogSaveHandler; // 接口调用日志异步保存服务

	public ApiInvokeLogSaveThread(
			ApiInvokeLogSaveHandler apiInvokeLogSaveHandler) {
		this.apiInvokeLogSaveHandler = apiInvokeLogSaveHandler;
	}

	@Override
	public void run() {
		for (;;) {
			try {
				BaseApiInvokeLog logData = ApiInvokeLogQueue.getInstance().poll();
				logger.info("队列中有数据，开始处理...");
				this.processSave(logData);
			} catch (Exception ex) {
				logger.error("接口调用日志异步保存线程处理错误：" + ex.getMessage());
			}
		}
	}

	public void processSave(BaseApiInvokeLog logData) {
		this.apiInvokeLogSaveHandler.saveLog(logData);
	}
}

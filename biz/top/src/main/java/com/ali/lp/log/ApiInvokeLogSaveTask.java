package com.ali.lp.log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ali.lp.log.service.ApiInvokeLogSaveHandler;


// 接口调用日志异步保存任务
@Service
public class ApiInvokeLogSaveTask {
    private int threadNum = 1;

   @Resource
    private ApiInvokeLogSaveHandler apiInvokeLogSaveHandler;
    
	// spring容器初始化调用init-method
    @PostConstruct
	public void init() {
	    // 处理线程数量等信息
		this.startTask();
	}

	// 接口调用日志异步保存线程启动
	public void startTask() {
		for (int i = 0; i < threadNum; i++) {
			Thread thread = new Thread(new ApiInvokeLogSaveThread(apiInvokeLogSaveHandler));
			thread.start();
		}
	}

	 // spring容器销毁调用 destroy-method
	@PreDestroy
	public void destory() {
		// 对队列中未处理完的数据做处理
	}
}

package com.ali.lp.log.service2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ali.lp.log.BaseApiInvokeLog;
import com.ali.lp.log.TopInvokeLogService;
import com.ali.lp.log.service.ApiInvokeLogSaveHandler;

/**
 * top接口调用日志异步保存服务类
 * TODO Comment of TopInvokeLogServiceImpl
 * @author wb_zhe.liz
 *
 */
@Service("topInvokeLogService")
public class TopInvokeLogServiceImpl implements TopInvokeLogService {
    private static final Logger logger = LoggerFactory.getLogger(TopInvokeLogServiceImpl.class);
    private int queueMaxSize = 100;
    private int threadNum = 1;
    
    @Resource
    private ApiInvokeLogSaveHandler apiInvokeLogSaveHandler;
    private BlockingQueue<BaseApiInvokeLog>  blockingQueue = new LinkedBlockingQueue<BaseApiInvokeLog>(queueMaxSize);

    @PostConstruct
    public void init() {
        this.startTask();
    }

    //@DependsOn
    public void startTask() {
        logger.info("api invoke log start... "); 
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(new LogSaveThread(this.apiInvokeLogSaveHandler));
            thread.start();
        }
    }

    @PreDestroy
    public void stopTask() {
        logger.info("api invoke destory "); 
    }
    
    @Override
    public boolean log(BaseApiInvokeLog logData) {
        boolean result = false;
        result = this.blockingQueue.offer(logData);
        return result;
    }
    
    
    //接口调用日志异步保存线程
    class LogSaveThread implements Runnable {

        private ApiInvokeLogSaveHandler apiInvokeLogSaveHandler; // 接口调用日志异步保存服务

        public LogSaveThread(ApiInvokeLogSaveHandler apiInvokeLogSaveHandler) {
            this.apiInvokeLogSaveHandler = apiInvokeLogSaveHandler;
        }

        @Override
        public void run() {
            for (;;) {
                try {
                    BaseApiInvokeLog result = null;
                    try {
                        result = blockingQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        logger.error("接口调用日志异步保存线程处理错误：" + e.getMessage());
                    }
                    logger.info("队列中有数据，开始处理...");
                    this.processSave(result);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    logger.error("接口调用日志异步保存线程处理错误：" + ex.getMessage());
                }
            }
        }

        public void processSave(BaseApiInvokeLog logData) {
            this.apiInvokeLogSaveHandler.saveLog(logData);
        }
    }
    
}

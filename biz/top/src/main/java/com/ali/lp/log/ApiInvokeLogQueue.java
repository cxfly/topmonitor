package com.ali.lp.log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// 接口调用日志队列
public class ApiInvokeLogQueue {
    public static final int QUEUE_MAX_SIZE = 10000; 
    private static ApiInvokeLogQueue logQueue = new ApiInvokeLogQueue();
    // 阻塞队列
    private BlockingQueue<BaseApiInvokeLog>    blockingQueue = new LinkedBlockingQueue<BaseApiInvokeLog>(QUEUE_MAX_SIZE);

    public static ApiInvokeLogQueue getInstance() {
        return logQueue;
    }

    public boolean push(BaseApiInvokeLog logData) { // 入队
        return this.blockingQueue.offer(logData);
    }

    public BaseApiInvokeLog poll() {//出队
        BaseApiInvokeLog result = null;
        try {
            result = this.blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int size() {// 获取队列大小
        return this.blockingQueue.size();
    }
}

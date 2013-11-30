package com.ali.lp.top.monitor;

import java.util.List;

import com.ali.lp.top.monitor.entity.TopClientMonitorInfo;

@Deprecated
public class SynTaskExecutorCacheLog implements Runnable {
    private List<TopClientMonitorInfo> dataCache;
    private long                       size      = 100 * 100 * 25;
//    private Object obj = new Object();

    public SynTaskExecutorCacheLog(List<TopClientMonitorInfo> dataCache) {
        super();
        this.dataCache = dataCache;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start execute ...");
        for (int i = 0; i < size; i++) {
            TopClientMonitorInfo monitorInfo = new TopClientMonitorInfo();
            monitorInfo.setId(i);
            synchronized (this.dataCache) {
                this.dataCache.add(monitorInfo);
                if (this.dataCache.size()%10000==0) {
                    System.out.println("====>>>"+Thread.currentThread().getName() + " " + this.dataCache.size());
                    try {
                        Thread.sleep((long)(Math.random()*1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        System.out.println(Thread.currentThread().getName() + " execute end ...");
    }


}

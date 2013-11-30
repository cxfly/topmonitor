package com.ali.lp.top.monitor;

import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.ali.lp.common.annotation.config.Config;
import com.ali.lp.top.client.serivce.SyncOrderService;


@Service("syncOrderWorkerExecutor")
public class SyncOrderWorkerExecutor {
	
    public static final Logger LOG = LoggerFactory.getLogger(SyncOrderWorkerExecutor.class);
    
	@Resource
	private SyncOrderService synOrderService;
	
	@Resource
	private ThreadPoolTaskExecutor topApiInvokeLogAsynSaveExecutor;
	
    @Config("per.thread.invoke.times")
    private long               invokeTimes;
	
	public boolean process(String taskName) {
	    LOG.info("==================== " + taskName + "  start execute ==============================");
		boolean result = false;
		
		List<Thread> ls = new Vector<Thread>();
		LOG.info(" start process Thread ");
		for (int i = 0; i < 100; i++) {
		    final String workName = taskName + "_work_" + (i+1);
		    
		    this.topApiInvokeLogAsynSaveExecutor.execute(new SyncOrderWorker(synOrderService, workName, invokeTimes));
		    
//		    Thread t = new Thread(new SyncOrderWorker(synOrderService, workName, invokeTimes), workName);
//	        t.start(); 
//	        ls.add(t);
        }

//		try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }

		while (true) {
			try {
				Thread.sleep(1000);
//				System.out.println(Runtime.getRuntime().totalMemory());
//				System.out.println(Runtime.getRuntime().maxMemory());
//				System.out.println(Runtime.getRuntime().freeMemory());
				boolean isAllDead = true;
				for (Thread t : ls) {
				    if (t.isAlive()) {
				        isAllDead = false;
				    }
                }
				if (isAllDead) {
				    result = true;
//				    topApiInvokeLogAsynSaveExecutor.destroy();
					break;
				}
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		LOG.info("==================== " + taskName + "  end execute ==============================");
		return result;
	}
}

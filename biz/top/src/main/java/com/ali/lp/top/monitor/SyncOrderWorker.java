package com.ali.lp.top.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ali.lp.top.client.serivce.SyncOrderService;

public class SyncOrderWorker implements Runnable {

	public static final Logger LOG = LoggerFactory.getLogger(SyncOrderWorker.class);
	private SyncOrderService synOrderService;
	private String workerName;
	
	private long invokeTimes;

	// private Object obj = new Object();

	public SyncOrderWorker(SyncOrderService synOrderService, String workerName, long invokeTimes) {
		super();
		this.synOrderService = synOrderService;
		this.workerName = workerName;
		this.invokeTimes= invokeTimes;
	}

	@Override
	public void run() {
	    LOG.info(this.workerName + " start execute ...");
		for (int i = 0; i < invokeTimes; i++) {
			try {
				this.synOrderService.invoke(this.workerName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*try {
				Thread.sleep(Math.round((new Random()).nextInt(2)));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}

	//	logger.info("worker " + this.worker + " execute end 9999...");
	}

}

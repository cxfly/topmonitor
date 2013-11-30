package com.ali.lp.log;

public class LogSaveThread implements Runnable {

	@Override
	public void run() {
		for(;;) {
			Object data = LogQueue.getInstance().queue.pull();
			this.process(data);
		}
	}
	
	
	private void process(Object data) {
		
	}

}

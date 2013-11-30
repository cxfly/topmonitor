package com.ali.lp.log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LogQueue {
	private static LogQueue logQueue = null;

	public BlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<Object>();
	public Queue<Object> queue = new Queue<Object>();

	public static synchronized LogQueue getInstance() {
		if (logQueue == null) {
			logQueue = new LogQueue();
		}
		return logQueue;
	}
}

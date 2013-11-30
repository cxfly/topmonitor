package com.ali.lp.log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.DependsOn;


public class LogSaveTask {

	/**
	 * init-method
	 */
	@PostConstruct
	public void init() {
		this.start();
	}

	@DependsOn
	public void start() {
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(new LogSaveThread());
			thread.start();
		}
	}

	/**
	 * destroy-method
	 */
	@PreDestroy
	public void destory() {
		
	}
}

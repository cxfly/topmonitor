package com.ali.lp.log;

import java.util.Vector;

public class Queue<T> {
	private Vector<T> data = new Vector<T>();

	/**
	 * 加入队列
	 * @param item
	 */
	public void push(T item) {
		synchronized (data) {
			data.addElement(item);
			data.notify();
		}
	}

	  /**
	   *从队首插入对象
	   * @param item
	   */
	public void pushTop(T item) {
		synchronized (data) {
			data.add(0, item);
			data.notify();
		}
	}

	/**
	 * 当没有数据时，等待 总是移出最前面一个数据对象，然后在队列中删除该对象
	 * 
	 * @return Object
	 */
	public Object pull() {
		Object item = null;
		synchronized (data) {
			while (data.isEmpty()) {
				try {
					data.wait();
				} catch (InterruptedException e) {
				}
			}
			item = data.firstElement();
			data.removeElement(item);
		}
		return item;
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public int getSize() {
		return data.size();
	}
}

package com.thread.producerConsumer;

import java.util.List;

public class Consumer implements Runnable {

	List<Integer> items;

	public Consumer(List<Integer> items) {
		this.items = items;
	}

	@Override
	public void run() {
		synchronized (items) {
			while (true) {
				if (items.size() <= 0) {
					try {
						items.wait();
						System.out.println("Consumer Waiting");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					items.remove(0);
					System.out.println("Consumer Removing");
					items.notify();
				}
			}
		}
	}

}

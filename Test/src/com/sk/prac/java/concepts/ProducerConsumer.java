package com.sk.prac.java.concepts;

import java.util.ArrayList;


public class ProducerConsumer {

	protected static ArrayList<Integer> resource = new ArrayList<>();
	protected final static int CAP =10;
	public static void main(String[] args) {
		produce();
		consume();
	}

	private static void produce() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(;;) {
					synchronized (resource) {
						if(resource.size() == CAP)
							try {
								//wait on resource as we have max elements.
								resource.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						int dd = (int) (Math.random()*10);
						resource.add(dd);
						System.out.println("added: "+dd);

						resource.notify();
						//notify on resource as we finished producing element.
					}
				}
			}
		}).start();
	}


	private static void consume() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(;;) {
					synchronized (resource) {
						if(resource.size() == 0)
							try {
								//wait on resource if it have no elements in it
								resource.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						System.out.println("Removed: "+resource.remove(0));
						resource.notify();
						//notify on resource as we consumed the element

					}
				}
			}
		}).start();

	}
}



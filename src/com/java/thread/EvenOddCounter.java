package com.java.thread;

public class EvenOddCounter {

	
	public static void main(String[] args) {
		Integer counter = 0;
		
		Thread even = new Thread(new EvenThread(counter));
		Thread odd = new Thread(new OddThread(counter));
		even.start();
		odd.start();

	}

	
}

class EvenThread implements Runnable {
	Integer counter;
	EvenThread(Integer counter){
		this.counter = counter;
	}

	@Override
	public void run() {
		printEven();
	}

	private void printEven() {
		while (counter < 10) {
			synchronized (counter) {
				if (counter % 2 == 0) {
					System.out.println("Even Thread counter " + counter);
					counter++;
					counter.notifyAll();
				} else {
					try {
						counter.wait(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}

class OddThread implements Runnable {
	Integer counter;
	OddThread(Integer counter){
		this.counter = counter;
	}

	@Override
	public void run() {
		printOdd();

	}

	private void printOdd() {
		while (counter < 10) {
			synchronized (counter) {
				if (!(counter % 2 == 0)) {
					System.out.println("Odd Thread counter " + counter);
					counter++;
					counter.notifyAll();
				} else {
					try {
						counter.wait(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}

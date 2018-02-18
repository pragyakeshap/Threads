package com.java.thread;

public class RunVsStart implements Runnable {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new RunVsStart());
		Thread t2 = new Thread(new RunVsStart());
		
		Thread t3 = new Thread(new RunVsStart());
		Thread t4 = new Thread(new RunVsStart());
		

		t3.run();
		t4.run();
		
		t1.start();
		t2.start();
		

		
	}
	

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+" " +  i);
				Thread.sleep(1000);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

/*
 * If we call run method, it is executed as the normal function and not as a Thread.
 * While, if we call start method, a new Thread is created, which inturn calls the run method of the Thread class
 * 
 * Output:

main 0
main 1
main 2
main 3
main 4
main 5
main 6
main 7
main 8
main 9
main 0
main 1
main 2
main 3
main 4
main 5
main 6
main 7
main 8
main 9
Thread-1 0
Thread-0 0
Thread-1 1
Thread-0 1
Thread-1 2
Thread-0 2
Thread-1 3
Thread-0 3
Thread-0 4
Thread-1 4
Thread-1 5
Thread-0 5
Thread-1 6
Thread-0 6
Thread-0 7
Thread-1 7
Thread-0 8
Thread-1 8
Thread-0 9
Thread-1 9
*/
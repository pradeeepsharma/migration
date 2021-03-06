package pk.playground.basics.thread.sync;

public class ThreadJoining {
	public static void main(String[] args) {

		Worker worker1 = new Worker("worker 1");
		Worker worker2 = new Worker("worker 2");
		Worker worker3 = new Worker("worker 3");

		try {
			worker1.start();
			worker1.join();

			worker2.start();
			worker2.join();

			worker3.start();
			worker3.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Worker extends Thread {
	private String name;

	public Worker(String name) {
		super(name);
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " :STARTED");
		for (int i = 0; i < 10; i++) {
			Math.random();
			System.out.println(threadName + " :RUNNING "+i );
		}
		System.out.println(threadName + " :STOPPED");
	}

}

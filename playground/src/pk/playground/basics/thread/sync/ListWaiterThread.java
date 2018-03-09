package pk.playground.basics.thread;

import java.util.List;

import pk.playground.model.User;

public class ListWaiterThread implements Runnable {

	private List<User> userList;

	public ListWaiterThread(List<User> userList) {
		this.userList = userList;

	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName+" started");
			try {
				for (int i = 0; i < 12; i++) {
					int size = userList.size();
					System.out.println("Size of the list in waiter :" + size);
					synchronized (userList) {
					if (size >= 10 && size<12) {
						System.out.println("Releasing lock");
						userList.wait();
						System.out.println("Lock reacquired");
					}
					System.out.println("Adding in list in waiter thread");
					userList.add(new User(i + 1, "User-" + (i + 1)));
				}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

}

package pk.playground.basics.thread;

import java.util.List;

import pk.playground.model.User;

public class ListPopulatorThread implements Runnable {

	private List<User> userList;

	public ListPopulatorThread(List<User> userList, String threadName) {
		this.userList = userList;

	}

	@Override
	public void run() {
		Thread.currentThread().setName("WaiterThread");
		try {
			for (int i = 0; i < 12; i++) {
				System.out.println("Size of ");
				if (userList.size() < 10) {
					userList.wait();
				}
				userList.add(new User(i + 1, "User-" + (i + 1)));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

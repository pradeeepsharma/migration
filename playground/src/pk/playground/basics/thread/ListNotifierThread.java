package pk.playground.basics.thread;

import java.util.List;

import pk.playground.model.User;

public class ListNotifierThread implements Runnable {

	private List<User> userList;

	public ListNotifierThread(List<? extends Object> userList) {
		this.userList = (List<User>) userList;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName);
		try {
			// Thread.sleep(1000);
			synchronized (userList) {
				userList.add(new User(1, "From_notifier"));
				userList.notify();
			}
		} catch (Exception ie) {
			ie.printStackTrace();
		}

	}

}

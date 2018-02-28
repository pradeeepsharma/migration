package pk.playground.basics.thread;

import java.util.List;

import pk.playground.model.User;

public class ListNotifierThread implements Runnable{
	
	private List<User> userList;

	public ListNotifierThread(List<? extends Object> userList) {
		this.userList = (List<User>)userList;
	}

	@Override
	public void run() {
		Thread.currentThread().setName("NotifierThread");
		System.out.println("Inside notifying thread");
		userList.add(new User(1, "From_notifier"));
		userList.notify();
		
	}

}

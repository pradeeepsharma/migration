package pk.playground.basics.thread.sync;

import java.util.ArrayList;
import java.util.List;

import pk.playground.model.User;

public class WaitAndNotify {
	
	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		Thread waitingThread = new Thread(new ListWaiterThread(userList));
		Thread notifyingThread = new Thread(new ListNotifierThread(userList));
		waitingThread.setName("WaitingThread");
		notifyingThread.setName("NotifyingThread");
		waitingThread.start();
		notifyingThread.start();
		try {
			notifyingThread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
	}

}

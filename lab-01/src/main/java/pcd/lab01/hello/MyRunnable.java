package pcd.lab01.hello;

public class MyRunnable implements Runnable {

	private String name;
	public MyRunnable(String name){
		this.name = name;
	}
	
	public void run(){
		log("Hello concurrent world!");
		log("Sleeping for 3 secs...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		log("Done.");
	}
	
	private void log(String msg) {
		System.out.println("[ " + System.currentTimeMillis() +   " ][ " + name + " ] " + msg); 
	}
}

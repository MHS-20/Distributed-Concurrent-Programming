package pcd.lab02.lost_updates;


public class Worker extends Thread {
	
	private SafeCounter counter;
	private int ntimes;
	
	public Worker(String name, SafeCounter counter, int ntimes){
		super(name);
		this.counter = counter;
		this.ntimes = ntimes;
	}
	
	public void run(){
		log("started");
		for (int i = 0; i < ntimes; i++){
			counter.inc();
		}
		log("completed");
	}
	
	private void log(String msg) {
		System.out.println("[ " + this.getName() + "] " + msg);
	}
	
}

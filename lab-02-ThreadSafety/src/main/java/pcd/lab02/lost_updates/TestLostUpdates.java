package pcd.lab02.lost_updates;

public class TestLostUpdates {

	public static void main(String[] args) throws Exception {
		
		int ntimes = 1000; // try with different values: 100, 200, 1000, 5000, ...
		
		if (args.length > 0) {
			ntimes = Integer.parseInt(args[0]);
		}
		
		SafeCounter c = new SafeCounter(0);
		Worker w1 = new Worker("Worker-A", c, ntimes);
		Worker w2 = new Worker("Worker-B", c, ntimes);

		Cron cron = new Cron();
		cron.start();
		
		w1.start();
		w2.start();

		w1.join();
		w2.join();
		
		cron.stop();
		
		System.out.println("Counter final value: " + c.getValue() + " in " + cron.getTime()+"ms.");
	}
}

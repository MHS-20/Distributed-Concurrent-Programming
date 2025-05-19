package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Unsynchronized version
 * 
 * @TODO make it sync 
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(String[] args) {
		Semaphore sPong = new Semaphore(0, true);
		Semaphore sPing = new Semaphore(1, true);
		AtomicInteger check = new AtomicInteger(1);
		new Pinger(sPing, sPong, check).start();
		new Ponger(sPing, sPong, check).start();
	}
}

package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;


public class Ponger extends ActiveComponent {

    public Ponger(Semaphore sPing, Semaphore sPong, AtomicInteger check) {
        super.sPong = sPong;
        super.sPing = sPing;
        super.check = check;
    }

    public void run() {
        while (true) {
            try {
                sPong.acquire();
                assertTrue(check.compareAndSet(Labels.PING.ordinal(), Labels.PONG.ordinal()));
                println("pong");
                sPing.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
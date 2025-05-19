package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;

public class Pinger extends ActiveComponent {

    public Pinger(Semaphore sPing, Semaphore sPong, AtomicInteger check) {
        super.sPong = sPong;
        super.sPing = sPing;
        super.check = check;
    }

    public void run() {
        while (true) {
            try {
                sPing.acquire();
                assertTrue(check.compareAndSet(Labels.PONG.ordinal(), Labels.PING.ordinal()));
                println("ping");
                sPong.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
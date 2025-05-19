package pcd.lab04.liveness.simplest_deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            lock1.lock();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock2.lock();
            lock2.unlock();
            lock1.unlock();
        });

        Thread t2 = new Thread(() -> {
            lock2.lock();
            lock1.lock();
            lock1.unlock();
            lock2.unlock();
        });

        t1.start();
        t2.start();
    }
}
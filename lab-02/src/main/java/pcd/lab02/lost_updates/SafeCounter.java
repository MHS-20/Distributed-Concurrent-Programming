package pcd.lab02.lost_updates;

public class SafeCounter {

    private int cont;

    public SafeCounter(int base) {
        this.cont = base;
    }

    public void inc() {
        synchronized (this) {
            cont++;
        }
    }

    public int getValue() {
        synchronized (this) {
            return cont;
        }
    }
}

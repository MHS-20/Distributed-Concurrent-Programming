package pcd.lab04.liveness.deadlock_obs;

public interface Observer {
	void notifyStateChanged(Observed obs);
}

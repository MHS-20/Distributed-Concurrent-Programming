package pcd.lab10.rmi.example_02;

import java.rmi.*;

public interface RemoteCounterListener extends Remote {

	void countIncremented(int currentCount) throws RemoteException;
	
}
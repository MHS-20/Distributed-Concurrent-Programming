package pcd.lab10.rmi.example_01;

import java.rmi.RemoteException;

public class MyServiceImpl implements MyService {
        
    public MyServiceImpl() {}

    public void printHello() throws RemoteException {
    	System.out.println("Hello, world!");
    }
    
    public int getSum(int a, int b) throws RemoteException {
    	return a + b;
    }

    public /* synchronized */ void receive(Message m) throws RemoteException {
    		System.out.println("Message received: " + m.getContent());
    	    // while (true) {} 
    }
        
}
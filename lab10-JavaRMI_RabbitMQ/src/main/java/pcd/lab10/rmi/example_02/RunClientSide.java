package pcd.lab10.rmi.example_02;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RunClientSide {

    private RunClientSide() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            var registry = LocateRegistry.getRegistry(host);
            var c = (Counter) registry.lookup("countObj");

            int value = c.getValue();
            log("count value " + value);
                        
            var l = new MyCounterListenerImpl();
            var proxy = (RemoteCounterListener) UnicastRemoteObject.exportObject(l, 0);
            c.addListener(proxy);
            
            c.inc();
            
            log("count value "+c.getValue());
            
        } catch (Exception e) {
            log("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

	private static void log(String msg) {
		System.out.println("[ " + System.currentTimeMillis() + " ][ Client Main ] " + msg);
	}

}


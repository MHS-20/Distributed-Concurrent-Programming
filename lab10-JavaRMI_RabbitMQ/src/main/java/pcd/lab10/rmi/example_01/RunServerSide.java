package pcd.lab10.rmi.example_01;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
        
public class RunServerSide  {
                
	private static final String OBJ_NAME = "myService";
	
    public static void main(String args[]) {
        
        try {
            MyService helloObj = new MyServiceImpl();
            MyService helloObjStub = (MyService) UnicastRemoteObject.exportObject(helloObj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            
            registry.rebind(OBJ_NAME, helloObjStub);
            
            System.out.println("Object registered.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
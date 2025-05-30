package pcd.lab05.chrono.v2;

/**
 * 
 * View designed as a monitor.
 * 
 * @author aricci
 *
 */
public class CounterView {

	private CounterGUI gui;
	
	public CounterView(Controller contr, int initialValue){	
		gui = new CounterGUI(contr,initialValue);
	}
	
	public synchronized void setCountingState() {
		gui.setCountingState();
	}

	public synchronized void setIdleState() {
		gui.setIdleState();
	}

	public synchronized void updateCountValue(int value) {
		gui.updateCountValue(value);
	}
	
	public synchronized void display() {
		gui.display();
    }
}

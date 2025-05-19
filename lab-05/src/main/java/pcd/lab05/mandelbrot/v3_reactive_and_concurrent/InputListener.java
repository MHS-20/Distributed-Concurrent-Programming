package pcd.lab05.mandelbrot.v3_reactive_and_concurrent;

public interface InputListener {

	void started(Complex c0, double diam);
	
	void stopped();
}

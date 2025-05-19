package pcd.lab05.mandelbrot.v1_not_reactive;

import java.util.*;

/**
 * Class representing the set to be computed - this is part of the model.
 * 
 * @author aricci
 *
 */
public class MandelbrotSet {

	private int w, h;
	private int nIterMax;
	
	/* 
	 * 
	 * This is the (color) matrix storing a portion of the Mandelbrot set 
	 * - each element is an RGB color
	 * 
	 */
	private int image[];

	private Complex currentCenter;
	private double currentDiameter;

	public MandelbrotSet(int w, int h, int nIterMax) {
		this.w = w;
		this.h = h;
		this.nIterMax = nIterMax;
		image = new int[w * h];
		currentCenter = null;
		currentDiameter = -1;
	}

	public int getSizeX() {
		return w;
	}

	public int getSizeY() {
		return h;
	}

	public int[] getImage() {
		return image;
	}

	public Complex getCurrentCenter() {
		return currentCenter;
	}

	public double getCurrentDiameter() {
		return currentDiameter;
	}

	/**
	 * Main function computing the set, specifying the
	 * portion of the set to be computed
	 * 
	 * @param c0
	 * @param diamX
	 */
	public void compute(Complex c0, double diamX) {
		double cx, cy;
		double diamY = diamX * h / w;
		double dx = diamX / w;
		double dy = diamY / h;
		double radiusX = diamX * 0.5;
		double radiusY = diamY * 0.5;
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				cx = x * dx + c0.re() - radiusX;
				cy = c0.im() + radiusY - y * dy;
				double color = computeColor(cx, cy, nIterMax);
				int c = (int) (color * 255);
				image[y * w + x] = c + (c << 8) + (c << 16);
			}
		}
	}

	/**
	 * Computed color:
	 * - black is the point is part of the Mandelbrot set
	 * - a value between 0 and 1: distance from the set - 1.0 max distance
	 * 
	 * @param x0
	 * @param y0
	 * @param maxIteration
	 * @return
	 */
	private double computeColor(double x0, double y0, int maxIteration) {
		int iteration = 0;
		double x = x0;
		double y = y0;
		while (x * x + y * y <= 4 && iteration < maxIteration) {
			double xtemp = x * x - y * y + x0;
			y = 2 * x * y + y0;
			x = xtemp;
			iteration++;
		}

		if (iteration == maxIteration) {
			/* point inside the set */
			return 0;
		} else {
			/* a value which depends on the distance wrt the set: 1.0 max distance */
			return 1.0 - 1.0 / maxIteration * iteration;
		}
	}

}

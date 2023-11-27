package MyObjects;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Obstacle extends Thread{
	private JTextArea panel;
	private int size;
	private int step;
	private int x0;
	private int y0;
	private int x;
	private int y;
	public Obstacle(JTextArea panel, int step, int size, int x0, int y0) {
		super();
		this.panel = panel;
		this.size = size;
		this.step = step;
		this.x0 = x0;
		this.y0 = y0;
	}
	
	public int GetHeight() {
		return size;
	}
	
	public int GetXCoord() {
		return x;
	}
	
	public int GetYCoord() {
		return y;
	}
	
	@Override
	public void run() {
		x = x0;
		y = y0;
		int ydir = 1;
		panel.setBackground(Color.GRAY);
		Graphics gr = panel.getGraphics();
		for(;;) {
			gr.setColor(Color.RED);
			gr.fillRect(x, y, size, size);
			try {
				Thread.sleep(30);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			gr.setColor(Color.GRAY);
			gr.fillRect(x, y, size, size);
			if (y > panel.getHeight() - size) ydir = -1;
			if (y < size) ydir = 1;
			y += ydir*step;
		}
	}
}

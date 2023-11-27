package MyObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Hero extends Thread{
	private Boolean isListened = true;
	private Boolean isLoose = false;
	private JTextArea panel;
	private int step = 5, size = 10, x = 10, y = 200;
	private final int UP = 38, DOWN = 40, LEFT = 37, RIGHT = 39;
	
	public Hero(JTextArea panel) {
		this.panel = panel;
	}
	
	private void MoveUp() {y-=step;}
	private void MoveDown() {y+=step;}
	private void MoveRight() {x+=step;}
	private void MoveLeft() {x-=step;}
	 
	@Override
	public void run() {
		Obstacle obs[] = new Obstacle[4];
		obs[0] = new Obstacle(panel,1,15,200,30);
		obs[1] = new Obstacle(panel,2,20,100,200);
		obs[2] = new Obstacle(panel,3,25,300,150);
		obs[3] = new Obstacle(panel,4,30,400,100);
		obs[0].start();
		obs[1].start();
		obs[2].start();
		obs[3].start();
		Graphics gr = panel.getGraphics();
		gr.setColor(Color.WHITE);
		gr.fillRect(x, y, size, size);
		panel.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (isListened) {
				gr.setColor(Color.GRAY);
				gr.fillRect(x, y, size, size);
				switch(e.getKeyCode()) {
				case UP:
					MoveUp();
					break;
				case DOWN:
					MoveDown();
					break;
				case LEFT:
					MoveLeft();
					break;
				case RIGHT:
					MoveRight();
					break;
				}
				
				gr.setColor(Color.WHITE);
				gr.fillRect(x, y, size, size);
			}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		for (;;) {
			if (isLoose) {
				gr.setColor(Color.RED);
				gr.fillRect(x, y, size, size);
				return;
			}
			for (Obstacle ob: obs) {
				if ((x+size<=ob.GetHeight()+ob.GetXCoord()) && (x>=ob.GetXCoord()) && (y+size<=ob.GetHeight()+ob.GetYCoord()) && (y>=ob.GetYCoord())) {
					gr.setColor(Color.RED);
					gr.fillRect(x, y, size, size);
					isListened = false;
					isLoose = true;
				}
			}
			if (x >= 450) {
				gr.setColor(Color.GREEN);
				gr.fillRect(x, y, size, size);
				isListened = false;
				return;
			}
		}
	}
	

}

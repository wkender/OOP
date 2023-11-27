package Listeners;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CheckListener implements ActionListener{
	private JFrame frame;
	private Random rand = new Random();
	public CheckListener(JFrame frame) {
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent arg0) {
		Color c = new Color((rand.nextInt(256)),rand.nextInt(256),rand.nextInt(256));
		frame.getContentPane().setBackground(c);
	}
}

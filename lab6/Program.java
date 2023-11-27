package MyObjects;

import java.awt.GridLayout;

import javax.swing.*;

public class Program {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new GridLayout());
		JTextArea panel = new JTextArea();
		frame.add(panel);
		frame.setVisible(true);
		Hero hero = new Hero(panel);
		hero.start();
	}

}

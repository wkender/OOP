package test;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Program {
	static JTextField numofcup;
	static JCheckBox sahar;
	static JCheckBox slivki;
	static JComboBox<String> type;
	static JButton ravno;
	static JTextField sum;
	static float a = 1, b = 1, c = 1, d = 1, f = 1;
	public static void SetParameters() {
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		numofcup = new JTextField("     ");
		sahar = new JCheckBox("Сахар?");
		slivki = new JCheckBox("Сливки?");
		type = new JComboBox<String>(new String[] {"Вкусный","Средний","Не оч"});
		JTextField sum = new JTextField("     ");
		ravno = new JButton("=");
		sum.setPreferredSize(new Dimension(100,40));
		frame.setSize(500,500);
		frame.add(numofcup);
		frame.add(sahar);
		frame.add(slivki);
		frame.add(type);
		frame.add(ravno);
		frame.add(sum);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500, 500);
		frame.setTitle("Coffee");
		frame.pack();
		frame.setVisible(true);
		ravno.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				if (sahar.isSelected()) b = (float) 1.2;
				else b = 1;
				if (slivki.isSelected()) c = (float) 1.3;
				else c = 1;
				if (type.getSelectedItem()=="Вкусный") d = 300;
				else if (type.getSelectedItem() == "Средний") d = 200;
				else d = 150;
				a = Float.parseFloat(numofcup.getText());
				sum.setText(String.valueOf(a*d*b*c));
			}
		});
		
	}
	
	
	
	public static void main(String args[]) {
		SetParameters();
	}
	
	

}

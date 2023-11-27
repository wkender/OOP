package Listeners;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
public class Listeners {
	public static String operations[] = {"DEC","BIN"};
	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculate");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		JCheckBox check = new JCheckBox("Рандом цвет");
		JComboBox<String> combobox = new JComboBox<String>(operations);
		JLabel label = new JLabel();
		label.setText("0");
		JTextField field = new JTextField();
		field.setPreferredSize(new Dimension(100,25));
		field.setText("0");
		JLabel label2 = new JLabel();
		label2.setText("Введите значение");
		BoxListener MyBoxListener = new BoxListener(combobox, label, field);
		field.addActionListener(MyBoxListener);
		CheckListener MyCheckListener = new CheckListener(frame);
		check.addActionListener(MyCheckListener);
		field.addCaretListener(new CaretListener(){

			@Override
			public void caretUpdate(CaretEvent e) {
				int index = combobox.getSelectedIndex();
				int val;
				if (index == 0) {
					try {
					val = Integer.parseInt(field.getText());
					label.setText(String.valueOf(val));
					} catch(NumberFormatException e1){
						System.out.println(e1);
					}
				}
				else {
					try {
					val = Integer.parseInt(field.getText());
					label.setText(Integer.toBinaryString(val));
					} catch(NumberFormatException e2) {
						System.out.println(e2);
					}
				}
				
			}
			
		});
		frame.add(combobox);
		frame.add(label2);
		frame.add(field);
		frame.add(label);
		frame.add(check);
		frame.setVisible(true);
	}

}

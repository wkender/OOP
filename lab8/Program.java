package MatrixOOP;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Program {
	public static JTextArea maxArea = new JTextArea(), sumArea = new JTextArea(), traceArea = new JTextArea();
	public static void main(String[] args) {
		Matrix matrix = new Matrix();
		JPanel panel = new JPanel();
		JTextArea matrixArea = new JTextArea();
		JFrame frame = new JFrame("Matrix");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		JComboBox<String> combo = new JComboBox<String>();
		frame.add(combo, BorderLayout.NORTH);
		frame.add(matrixArea, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.EAST);
		
		for (IGenerator generator : MatrixData.generators) {
			combo.addItem(generator.getName());
		}
		for (IMatrixListener listen : MatrixData.listeners) {
			panel.add((JTextArea) listen);
			matrix.addListener(listen);
		}
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				matrix.setGenerator(MatrixData.generators[combo.getSelectedIndex()]);
				matrix.update();
				String text = "";
				for (int i = 0; i < matrix.getSize(); i++) {
					for (int j = 0; j < matrix.getSize(); j++) {
						text += matrix.getValue(i, j);
						text += " ";
					}
					text += "\n";
				}
				matrixArea.setText(text);
			}
			
		});
		frame.setVisible(true);
	}

}

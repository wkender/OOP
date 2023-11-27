package Listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoxListener implements ActionListener{
	private JComboBox<String> combobox;
	private JLabel label;
	JTextField field;
	
	public BoxListener(JComboBox<String> combobox,JLabel label,JTextField field) {
		this.combobox = combobox;
		this.label = label;
		this.field = field;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = combobox.getSelectedIndex();
		int val;
		if (index == 0) {
			val = Integer.parseInt(field.getText());
			label.setText(String.valueOf(val));
		}
		else {
			val = Integer.parseInt(field.getText());
			label.setText(Integer.toBinaryString(val));
		}
	}
}

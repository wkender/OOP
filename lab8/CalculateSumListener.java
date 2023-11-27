package MatrixOOP;

import javax.swing.JTextArea;

public class CalculateSumListener extends JTextArea implements IMatrixListener{

	@Override
	public void matrixUpdated(Matrix matrix) {
		long sum = 0;
		for (int i = 0; i < matrix.getSize(); i++) {
			for (int j = 0; j < matrix.getSize();j++) {
				sum += matrix.getValue(i, j);
			}
		}
		setText("sum = " + String.valueOf(sum));
	}
	
}

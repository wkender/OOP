package MatrixOOP;

import javax.swing.JTextArea;

public class CalculateMaxListener extends JTextArea implements IMatrixListener{

	@Override
	public void matrixUpdated(Matrix matrix) {
		long max = 0;
		for (int i = 0; i < matrix.getSize(); i++) {
			for (int j = 0; j < matrix.getSize(); j++) {
				if (max < matrix.getValue(i, j)) max = matrix.getValue(i, j);
			}
		}
		setText("Max = " + String.valueOf(max));
	}
	
}

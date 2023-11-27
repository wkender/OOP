package MatrixOOP;

import javax.swing.JTextArea;

public class CalculateMinListener extends JTextArea implements IMatrixListener{

	@Override
	public void matrixUpdated(Matrix matrix) {
		long min = 12334;
		for (int i = 0; i < matrix.getSize(); i++) {
			for (int j = 0; j < matrix.getSize(); j++) {
				if (min > matrix.getValue(i, j)) min = matrix.getValue(i, j);
			}
		}
		setText("min = " + String.valueOf(min));
		
	}

}

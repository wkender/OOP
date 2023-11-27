package MatrixOOP;

import javax.swing.JTextArea;

public class CalculateTraceListener extends JTextArea implements IMatrixListener {

	@Override
	public void matrixUpdated(Matrix matrix) {
		long trace = 0;
		for (int i = 0; i < matrix.getSize(); i++) {
			trace += matrix.getValue(i, i);
		}
		setText("trace = " + String.valueOf(trace));
	}

}

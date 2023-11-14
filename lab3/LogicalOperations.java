package Operations;

public class LogicalOperations {
	public static void main(String args[]) {
		OperandInterface[] operands = {new AND(), new NAND(),new OR(),new XOR()};
		int a = 10, b = 12;
		for (OperandInterface op : operands) {
			System.out.printf("%s\n%s %s %s = %s\n",op.OperationName(),Integer.toBinaryString(a),op.OperandName(),
			Integer.toBinaryString(b),Integer.toBinaryString(op.Result(a, b)));
		}
	}
}

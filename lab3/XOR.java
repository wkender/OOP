package Operations;

public class XOR implements OperandInterface {
	@Override
	public String OperationName() {
		return("Исключающее или");
	}
	@Override
	public String OperandName() {
		return("XOR");
	}
	@Override
	public int Result(int a, int b) {
		return a^b;
	}
}

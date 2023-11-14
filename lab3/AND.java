package Operations;

public class AND implements OperandInterface {
	@Override
	public String OperationName() {
		return("И");
	}
	@Override
	public String OperandName() {
		return("&");
	}
	@Override
	public int Result(int a, int b) {
		return a&b;
	}
}

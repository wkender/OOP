package Operations;

public class OR implements OperandInterface{
	@Override
	public String OperationName() {
		return("Или");
	}
	@Override
	public String OperandName() {
		return("OR");
	}
	@Override
	public int Result(int a, int b) {
		return a|b;
	}
}

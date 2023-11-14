package Operations;

public class NAND implements OperandInterface{
	@Override
	public String OperationName() {
		return("Штрих Шеффера");
	}
	@Override
	public String OperandName() {
		return("NAND");
	}
	@Override
	public int Result(int a, int b) {
		return (~(a&b)^~(0xF));
	}
}

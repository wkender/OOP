package MatrixOOP;

public class IdentityGenerator implements IGenerator{

	@Override
	public String getName() {
		return "Единичная";
	}

	@Override
	public long getElement(int i, int j) {
		return i == j? 1 : 0;
	}

}

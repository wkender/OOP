package MatrixOOP;

public class RandomGenerator implements IGenerator {

	@Override
	public String getName() {
		return "Случайная";
	}

	@Override
	public long getElement(int i, int j) {
		return (long) Math.floor(Math.random()*100);
	}

}

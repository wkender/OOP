package MatrixOOP;

public class TriangleGenerator implements IGenerator{

	@Override
	public String getName() {
		return "Треугольная";
	}

	@Override
	public long getElement(int i, int j) {
		return (long) (j < i? 0 : Math.floor(Math.random()*100));
	}

}

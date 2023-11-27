package MatrixOOP;

public class MatrixData {
	public static IGenerator[] generators = {new ZeroGenerator(), new RandomGenerator(), 
	new IdentityGenerator(), new DiagonalGenerator(), new TriangleGenerator()};
	public static IMatrixListener[] listeners = {new CalculateMaxListener(),
	new CalculateTraceListener(), new CalculateSumListener(), new CalculateMinListener()};
}

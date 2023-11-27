package Exceptions;

public class Calculator {
	private int a, b;
	private char c;
	private float result;
	public Calculator(int a, int b, char c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public float Result() {
		result = 0;
		switch(c) {
		case '*':
			result = a*b;
			break;
		case '+':
			result = a+b;
			break;
		case '-':
			result = a-b;
			break;
		case '/':
			try {
				if (b == 0) throw new ArithmeticException("Ошибка - деление на ноль");
				result = (float) a/(float) b;
			} catch (ArithmeticException e) {
				System.out.println(e);
			}
			break;
		default:
			System.out.println("Не существует такого операнда!");
			break;
		}
		return result;
	}
}

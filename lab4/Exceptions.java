package Exceptions;

import java.io.IOException;
import java.util.Scanner;

public class Exceptions {

	public static void main(String[] args) {
		int a = 0,b = 0;
		char c = ' ';
		Scanner in = new Scanner(System.in);
		try {
		System.out.print("Введите первое число:");
		a = in.nextInt();
		System.out.print("Введите второе число:");
		b = in.nextInt();
		System.out.print("Введите операнд:");
		c = in.next().charAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calculator calc = new Calculator(a,b,c);
		float result = calc.Result();
		System.out.printf("Полученный результат: %f", result);
		in.close();
	}

}

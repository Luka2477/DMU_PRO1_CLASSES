package modelwhile;

import java.lang.annotation.IncompleteAnnotationException;

public class Loekker {
	public void udskriv1_10() {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");

	}

	public void udskriv1_10_iteration() {
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}
	}

	public int summer() {
		int sum = 0;
		int i = 1;
		while (i <= 10) {
			sum = sum + i;
			i++;
			
		}
		return sum;

	}

	public int summer(int n) {
		int sum = 0;
		int i = 1;
		while (i <= n) {
			sum = sum + i;
			i++;
		}
		return sum;

	}

	public int multiplum(int a, int b) {
		int resultat = 0;
		int i = 0;
		while (i < a) {
			resultat = resultat + b;
			i++;
		}
		return resultat;

	}

	public int summerEven() {
		int i = 2;
		int sum = 0;
		while(i <= 100) {
			sum += i;
			i += 2;
		}
		return sum;
	}

	public int summerSquare() {
		int i = 1;
		int increment = 3;
		int sum = 0;
		while(i <= 100) {
			sum += i;
			i += increment;
			increment += 2;
		}
		return sum;
	}

	public void allPowers() {
		int power = 0;
		int number = 1;
		while(power <= 20) {
			System.out.println(number);
			number *= 2;
			power++;
		}
	}

	public int sumOdd(int a, int b) {
		a += (a % 2 != 0) ? 0 : 1;
		int sum = 0;
		while(a <= b) {
			sum += a;
			a += 2;
		}
		return sum;
	}

	public int sumOfOddDigitsFor(int number) {
		String[] numbers = ("" + number).split("");
		int sum = 0;
		for(String element : numbers) {
			int num = Integer.parseInt(element);
			if(num % 2 != 0) {
				sum += num;
			}
		}
		return sum;
	}

	public int sumOfOddDigitsWhile(int number) {
		int sum = 0;
		int divider = (int)Math.pow(10, ("" + number).length()-1);

		while(divider > 0) {
			int num = number / divider;

			if(num % 2 != 0) sum += num;

			number %= divider;
			divider /= 10;
		}
		return sum;
	}
}

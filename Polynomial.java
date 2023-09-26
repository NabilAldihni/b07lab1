import java.lang.Math;

public class Polynomial {
	public double coefficients[];
	public int exponents[];

	public Polynomial() {
		this.coefficients = new double[0];
	}

	public Polynomial(double coefficients[], int exponents[]) {
		this.coefficients = new double[coefficients.length];
		this.exponents = new int[exponents.length];
		for (int i=0; i<coefficients.length; i++) {
			this.coefficients[i] = coefficients[i];
			this.exponents[i] = exponents[i];
		}
	}

	public Polynomial add(Polynomial poly) {
		int exponents1 = this.maxExp(this.exponents);
		int exponents2 = this.maxExp(poly.exponents);
		double poly1[] = new double[exponents1];
		double poly2[] = new double[exponents2];

		for (int i=0; i<exponents1; i++) {
			poly1[exponents1[i]] = this.coefficients[i];
		}
		for (int i=0; i<exponents2; i++) {
			poly1[exponents2[i]] = poly.coefficients[i];
		}


	}

	private int maxExp(int arr[]) {
		if (arr.length == 0) {
			return 0;
		}
		int max = arr[0];
		for (int e : arr) {
			if (e > max) {
				max = e;
			}
		}

		return max;
	}

	public double evaluate(double x) {
		double result = 0.0;
		for (int i=0; i<this.coefficients.length; i++) {
			result += this.coefficients[i] * (Math.pow(x,exponents[i]));
		}
		
		return result;
	}

	public boolean hasRoot(double root) {
		if (evaluate(root) == 0) {
			return true;
		}
		return false;
	}
}

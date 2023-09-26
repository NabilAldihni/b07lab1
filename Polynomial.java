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
		int a_len = this.coefficients.length;
		int b_len = poly.coefficients.length;
		double sum[] = new double[a_len + b_len];

		for (int i=0; i<a_len; i++) {
			sum[this.exponents[i]] += this.coefficients[i];
		}
		for (int i=0; i<b_len; i++) {
			sum[poly.exponents[i]] += poly.coefficients[i];
		}

		int counter = 0;
		for (int i=0; i<a_len+b_len; i++) {
			if (sum[i] != 0) {
				counter++;
			}
		}

		double resulting_coefficients[] = new double[counter];
		int resulting_exponents[] = new int[counter];

		counter = 0;
		for (int i=0; i<a_len+b_len; i++) {
			if (sum[i] != 0) {
				resulting_coefficients[counter] = sum[i];
				resulting_exponents[counter] = i;
				counter++;
			}
		}

		return new Polynomial(resulting_coefficients, resulting_exponents);
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

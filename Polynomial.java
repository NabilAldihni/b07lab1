import java.lang.Math;

public class Polynomial {
	public double coefficients[];

	public Polynomial() {
		this.coefficients = new double[1];
		this.coefficients[0] = 0;
	}

	public Polynomial(double coefficients[]) {
		this.coefficients = new double[coefficients.length];
		for (int i=0; i<coefficients.length; i++) {
			this.coefficients[i] = coefficients[i];
		}
	}

	public Polynomial add(Polynomial poly) {
		int a_len = this.coefficients.length;
		int b_len = poly.coefficients.length;
		int max_len = Math.max(a_len, b_len);
		int min_len = Math.min(a_len, b_len);
		double result[] = new double[max_len];
		for (int i=0; i<min_len; i++) {
			result[i] = this.coefficients[i] + poly.coefficients[i];
		}
		for (int i=min_len; i<max_len; i++) {
			result[i] = poly.coefficients[i];
		}
	
		return new Polynomial(result);
	}

	public double evaluate(double x) {
		double result = 0.0;
		for (int i=0; i<this.coefficients.length; i++) {
			result += this.coefficients[i] * (Math.pow(x,i));
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

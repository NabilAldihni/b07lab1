import java.lang.Math;

public class Polynomial {
	public double coefficients[];
	public int exponents[];

	public Polynomial() {
		this.coefficients = new double[0];
		this.exponents = new int[0];
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
		int exponents1 = this.maxExp(this.exponents) + 1;
		int exponents2 = this.maxExp(poly.exponents) + 1;
		double poly1[] = new double[exponents1];
		double poly2[] = new double[exponents2];

		for (int i=0; i<this.exponents.length; i++) {
			poly1[this.exponents[i]] = this.coefficients[i];
		}
		for (int i=0; i<poly.exponents.length; i++) {
			poly2[poly.exponents[i]] = poly.coefficients[i];
		}

		double result[] = new double[Math.max(exponents1, exponents2)];
		for (int i=0; i<exponents1; i++) {
			result[i] += poly1[i];
		}
		for (int i=0; i<exponents2; i++) {
			result[i] += poly2[i];
		}

	 	int non_zeros = 0;
	 	for (int i=0; i<result.length; i++) {
			if (result[i] != 0) {
				non_zeros++;
			}
		}

		double co[] = new double[non_zeros];
		int ex[] = new int[non_zeros];
		int counter = 0;
		for (int i=0; i<result.length; i++) {
			if (result[i] != 0) {
				ex[counter] = i;
				co[counter] = result[i];
				counter++;
			}
		}

		return new Polynomial(co, ex);

	}

	public Polynomial multiply(Polynomial poly) {
		int exponents1 = this.exponents.length;
		int exponents2 = poly.exponents.length;
		Polynomial final_poly = new Polynomial();
		for (int i=0; i<exponents1; i++) {
			double temp_co[] = new double[exponents2];
			int temp_exp[] = new int[exponents2];
			for (int j=0; j<exponents2; j++) {
				temp_co[j] = this.coefficients[i] * poly.coefficients[j];
				temp_exp[j] = this.exponents[i] + poly.exponents[j];
			}


			Polynomial temp_poly = new Polynomial(temp_co, temp_exp);
			final_poly = final_poly.add(temp_poly);
		}

		return final_poly;
	}

	private void printArr(double arr[]) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private void printArr(int arr[]) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	@Override
	public String toString() {
		String ret = "";
		
		for (int x=0; x<this.coefficients.length; x++) {
			ret += this.coefficients[x] + " ";
		}
		ret += "\n";
		for (int y=0; y<this.exponents.length; y++) {
			ret += this.exponents[y] + " ";
		}

		return ret;
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

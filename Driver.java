import java.io.File;
import java.io.IOException;

public class Driver {
	public static void main(String [] args) {
		double [] c1 = {7,2,1};
		int [] e1 = {0,4,9};
		Polynomial p1 = new Polynomial(c1, e1);
		double [] c2 = {3,3,5,20};
		int [] e2 = {1,4,7,11};
		Polynomial p2 = new Polynomial(c2, e2);
		String filename = "C:\\Users\\nabil\\Documents\\b07\\b07lab1\\file.txt";
		try {
			Polynomial p = new Polynomial(new File(filename));
			//System.out.println(p);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		// Polynomial s = p1.add(p2);
		// Polynomial s = p1.multiply(p2);
		// for (double co : s.coefficients) {
			// System.out.print(co + " ");
		// }
		// System.out.println();
		// for (int ex : s.exponents) {
			// System.out.print(ex + " ");
		// }
	}
}

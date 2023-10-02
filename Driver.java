import java.io.File;
import java.io.IOException;

public class Driver {
	public static void main(String [] args) {
		String filename = "C:\\Users\\nabil\\Documents\\b07\\b07lab1\\file.txt";
		String filename2 = "C:\\Users\\nabil\\Documents\\b07\\b07lab1\\file2.txt";
		try {
			Polynomial p1 = new Polynomial(new File(filename));
			Polynomial p2 = new Polynomial(new File(filename2));
			Polynomial s = p1.add(p2);
			//Polynomial s = p1.multiply(p2);
			System.out.println(s);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

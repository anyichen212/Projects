import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		
		Concordance concor = new Concordance();
		concor.add();
		System.out.println(concor);
		System.out.println("Total count of the word Yellow : " +  concor.count("yellow"));
		

	}

}

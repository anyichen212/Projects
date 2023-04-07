import java.io.*;
import java.util.*;

public class Concordance {

	private Map<String, List<Token>> map;
	private ArrayList<Token> list;
	private Tokenizer tokenizer;
	
	public Concordance() {
		
		list = new ArrayList<>();
		map = new TreeMap<>();
	}
	
	//add(). This opens up a file and adds all Tokens to the map.
	public void add() {
		Token temp;
		tokenizer = new Tokenizer(new File("Bee Movie Script"));
		while (tokenizer.hasNext()) {
			temp = tokenizer.next();
			map.put(temp.getWord(), list);
			list.add(temp);
		}
	}
	
	//a toString() method that creates a String representation of the Concordance.
	public String toString() {
		String temp = "";
		
		tokenizer = new Tokenizer(new File("Bee Movie Script"));
		while (tokenizer.hasNext()) {
			temp = temp + tokenizer.next()+ "\n";
		}
		
		return list.get(list.size()-1).getFileName() + " Concordance"
		+ "\n\n" 
		+ temp;
	}
	
	//a method called count() that returns how many times a String occurs. 
	public int count(String a) {
		int count = 0;
		Token temp;
		tokenizer = new Tokenizer(new File("Bee Movie Script"));
		
		while (tokenizer.hasNext()) {
			temp = tokenizer.next();
			if(a.equals(temp.getWord()))
					count++;
		}
		
		return count;
		
	}

}

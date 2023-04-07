import java.io.*;
import java.util.*;

public class Tokenizer {

	Scanner sc;
	Token tk;
	ArrayList<Token> list;
	int size = 0;
	int track = -1;
	
	//A constructor that accepts the name of a file and opens it. 
	public Tokenizer(File a) {
		try {
			sc = new Scanner(a);
		} catch (FileNotFoundException e) {
			System.err.print("No files!");
		}
		
		list = new ArrayList<>();
		
		while(sc.hasNext()) {
			tk = new Token();
			size++;
			tk.setWord(sc.next());
			tk.setCount(size);
			list.add(tk);
		}
		tk.setFileName(a.getName());
	}
	
	
	//A method called next() that returns the next Token.
	public Token next() {
		while(hasNext()) {
			track++;
		    return list.get(track);
		}
		
		return null;
	}
	
	//A method called hasNext() that returns whether or not the file has any more Tokens.
	public boolean hasNext() {
		if(track == size-1) {
			return false;
		}
		return true;
	}

}

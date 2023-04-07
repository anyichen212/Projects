public class Token {
	
	//store information about a word and where it can be found within a file
	
	//private Scanner sc;
	private String fileName;
	private String word;
	private int count = 0; //remembers which word in the file it is (i.e. how many words into the file it is)

	public Token() {
	}
	
	//String representation for the Token
	public String toString() {
		return "#" + count + " : " + word;
	}
	
	public void setFileName(String a) {
		fileName = a;
		
	}

	public String getFileName() {
		return fileName;
	}
	
	public void setCount(int a) {
		count = a;
		
	}
	
	public void setWord(String a) {
		word = a.toLowerCase();
		if (word.substring(word.length()-1).equals(",") || word.substring(word.length()-1) .equals(".") || word.substring(word.length()-1) .equals("!"))
			word = word.substring(0, word.length()-1);
	}

	public String getWord() {
		return word;
	}

}

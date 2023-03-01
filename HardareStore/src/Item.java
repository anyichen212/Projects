
public class Item {
	
	private String name;
	private int price;
	
	//constructor
	public Item(String name, int price) {
		
		this.name = name;
		this.price = price;
	}
	
	//get name method
	public String getName() {
		return name;
	}
	
	//get price method, return price in cents
	public int getPrice() {
		return price;
	}
	
	//toString method, returns (item  $price)
	public String toString() {
		
		//if the cent area is less than 10, add a "0" in front for accurate format purpose
		if(price%100 < 10) {
			return "\n" + name + "  $" + price/100 + ".0" + price%100; 
		}
		
		return "\n" + name + "  $" + price/100 + "." + price%100;
	}

}

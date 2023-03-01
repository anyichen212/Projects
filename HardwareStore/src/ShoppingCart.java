import java.util.*;

public class ShoppingCart {

	LinkedList<Item> list;
	private int size = 0;
	private int total = 0;
	
	public ShoppingCart() {
		list = new LinkedList<>();
	}
	
	//add an item into the shopping cart
	public void addItem(Item item) {
		
		list.add(item);
		size++;
		total = total + item.getPrice();
	}
	
	//This returns the total price of all of the items in the shopping cart in cents. 
	public int grandTotal() {
		
		return total;
		
	}
	
	//This returns the number of items in the shopping cart. 
	public int numItems() {
		return size;
	}
	
	//This creates a String representation for a ShoppingCart. 
	public String toString() {
		return list.toString();
	}

}

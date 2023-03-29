
public class Shopper implements Comparable<Shopper> {

	private String first;
	private String last;
	ShoppingCart sc;
	
	//This creates a shopper with this name and with an empty ShoppingCart. 
	public Shopper(String firstName, String lastName) {
		first = firstName;
		last = lastName;
		sc = new ShoppingCart();
	}
	
	//if shopper only enter a first name or is a corp
	public Shopper(String firstName) {
		first = firstName;
		last = "";
		sc = new ShoppingCart();
	}
	
	public void addItemToCart(Item item, int numItems) {
		
		//add item [numItems] amount of time in sc
		for(int i =0 ; i < numItems ; i++ )
		sc.addItem(item);
	}
	
	//If no second parameter is specified, only one item should be added.
	public void addItemToCart(Item item) {
		
		sc.addItem(item);
	}
	
	// the amount of money in cents that Shopper needs to pay the cashier in the hardware store.
    //the total cost of the items in the cart plus an additional 8.875% tax. 
	//The price should be rounded to the nearest cent.  
	public int amountOwed() {
		
		int temp = (int)(sc.grandTotal()+ Math.ceil(sc.grandTotal()*0.08875));
		
		return temp; //amount in cents
	}
	
	public String toString() {
		
		double temp = (double)(this.amountOwed())/100; //convert to double and converts cent to dollar
		
		//returns
		//Firstname Lastname
		//[Shopping cart list]
		//
		//amount owe
		return first + " " + last + "'s Shopping cart" + 
				"\n" + sc +
				"\n\n" + "Total Cost : $" + String.format("%.2f", temp); //format the price to 2 decimal places
	}


	@Override
	public int compareTo(Shopper shopper) {
		
		//return a negative number if “this” has a bigger total to pay than “shopper”
		if(this.amountOwed()> shopper.amountOwed())
			return -1;
		
		//return a positive number if “shopper” has a bigger total than “this”
		if(this.amountOwed()< shopper.amountOwed())
			return 1;
		
		//0 if they owe the same amount
		return 0;
	}

}

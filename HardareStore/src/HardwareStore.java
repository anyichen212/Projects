import java.util.*;

public class HardwareStore {
	
	private PriorityQueue<Shopper> queue;
	double total = 0; //in cents

	//Creates a HardwareStore with the specified number of registers. (i.e. the number ofqueues). 
	public HardwareStore() {
		queue = new PriorityQueue<>();
	}
	
	//Adds a shopper into the PriorityQueue in order to order them by their shopping cart total. 
	public void addShopperToLine(Shopper shopper) {
		queue.add(shopper);
	}
	
	//Takes all shoppers out of the priority queue and processes them.
	public void checkoutAllShoppers() {
		while(queue.peek()!= null) {
		total = total + queue.poll().amountOwed(); //retrieve and remove from queue, then add the retrieve data to total
		}
	}
	
	//Returns the amount of money the HardwareStore has taken in so far.
	public double totalRevenue() {
		return total/100;
		
	}

}

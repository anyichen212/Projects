import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		HardwareStore store = new HardwareStore();
		Shopper shopper;
		Inventory inv = new Inventory(); //new inventory that scans the inventory file
		Item a;
		
		//File file = new File("/event.txt");
		Scanner sc = new Scanner(new File("event.txt")); //import the event file
		
		String first;
		String last;
		int numOfItem;
		String nextItem;
		int amount;
		
		while(sc.hasNextLine()) {
			
			first = sc.next(); //scan next string as FirstName
			last = sc.next(); //scan next string as LastName
			shopper = new Shopper(first, last); //create new shoppper with the scan first and last name
			
			//System.out.println(first + " " + last + " " + sc.hasNextInt());
			
			numOfItem = sc.nextInt(); //number of different items

			for(int i = 0 ; i < numOfItem ; i++) {
				amount = sc.nextInt(); //amount of the item
				nextItem = sc.next(); //the item name
				
				a = inv.returnInventory(nextItem); //grab the item with the same String name from inventory
				shopper.addItemToCart(a, amount); //add the amount of the item into the current shopper cart

			}
			
			store.addShopperToLine(shopper); //add the shopper in store
			
			System.out.println(shopper); //prints the shopper and their list
			System.out.println();
		}
			
		store.checkoutAllShoppers(); //checkout all shopper
		System.out.println("Total Store Revenue : $" + store.totalRevenue()); //print the store revenue

	}
}

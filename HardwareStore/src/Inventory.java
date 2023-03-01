import java.io.*;
import java.util.*;

public class Inventory {
	Scanner sc;
	Map<String,Integer> list; //a list of the hardware items, the menu

	public Inventory() throws Exception {
		list = new HashMap<>();
		sc = new Scanner(new File("inventory.txt"));
		
		while (sc.hasNext()) {
			list.put(sc.next(),sc.nextInt());
		}
	}
	
	public Item returnInventory(String item) {
		
		//if the inventory does not contain the item, return null
		if(!(list.containsKey(item)))
			return null;
		
		Item temp = new Item(item , list.get(item)); //create temporary item, grab price from 'list' and return the item
		
		return temp;
	}

}

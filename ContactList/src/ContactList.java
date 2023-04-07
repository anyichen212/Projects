import java.util.*;

public class ContactList<E>{
	
	private ArrayList<Contact> list;

	//empty ContactList constructor
	ContactList(){
		list = new ArrayList<>();
	}
	
	//constructor that uses an array of Contacts in order to initialize the ContactList
	public ContactList(Contact [ ] contact){
		//can use  Arrays.asList() method
		list = new ArrayList<>(Arrays.asList(contact));
	}
	
	
	//Method that searches for a particular contact by last name, and returns a reference to the Contact. 
	//If there is no such Contact, null should be returned 
	//Since the list is in sorted order, this method should be a binary search of the list. 
	public Contact findByLastName(String last) {
		
		Iterator<Contact> iter = list.iterator();
		String a;
		Contact c;
		
		while(iter.hasNext()) {
			c = iter.next();
			a = c.getLastName();
			if (a.equals(last))
				return c;
		}
		return null;
	}
	
	//method that searches for a Contact by phone number, and returns a reference to the Contact.
	//If there is no such Contact, null should be returned.
	public Contact findByPhoneNumber(String phone) {
		
		Iterator<Contact> iter = list.iterator();
		Contact c;
		
		while(iter.hasNext()) {
			c = iter.next();
			if(c.getPhoneNum().equals(phone))
				return c;
		}
		return null;
	}
	
	//method that searches for and returns a ContactList containing all Contacts with a last name starting with a particular letter 
	//If there are no such Contacts, you should return the empty ContactList. 
	ContactList<Contact> findAllByLastInitial(char ch) {
		
		ContactList<Contact> list2 = new ContactList<Contact>();
		Iterator<Contact> iter = list.iterator();
		Contact c;
		
		while(iter.hasNext()) {
			c = iter.next();
			if(c.getLastName().charAt(0)== ch)
				list2.add(c);
		}
		return list2;
	}
	
	//method that searches for and returns a ContactList containing all Contacts that live
    //in a particular city.
	//If there are no such Contacts, you should return the empty ContactList.
	ContactList<Contact> findAllByCity(String city) {
		
		ContactList<Contact> list2 = new ContactList<Contact>();
		Iterator<Contact> iter = list.iterator();
		Contact c;
		
		while(iter.hasNext()) {
			c = iter.next();
			if(c.getCity().equals(city))
				list2.add(c);
		}
		return list2;
	}
	
	/* A method that allows you to add a Contact to the ContactList in sorted order. You
	 *should only add a Contact to the list if it is not there already. Use a modified binary
	 *search to determine this. The method returns true if the add is successful and false if
	 *it is unsuccessful. */
	boolean add(Contact c) {
		if(list.contains(c)) {
			return false;
		}
		
		Iterator<Contact> iter = list.iterator();
		Contact a = null;
		int count = 0;
		
		while(iter.hasNext()) {
			a=iter.next();
			if(a.compareTo(c) == -1) {
				count++;
			}
		}
		
		list.add(count , c);
		return true;
	}
	
	//A method that returns the size of the ContactList.
	int size() {
		return list.size();
	}
	
	//A method that allows you to remove and return a Contact from the ContactList. 
	Contact remove(Object obj) {
		Contact a = (Contact)obj; 
		list.remove(a);
		return a;
	}
	
	//method that allows the client to get a Contact from the ContactList by index
	//An method that allows the client to get a Contact from the ContactList by index
	Contact get(int index) {
		if(index<0 || index >= list.size()) {
			throw new IndexOutOfBoundsException();
		}
		return list.get(index);
	}
	
	//An overridden equals() method.
	//Let’s define one ContactList being equal to another
	//if they contain the same Contacts in the same order. 
	public boolean equals(Object obj) {
		return list.equals(obj);
	}
	
	//An overridden toString() method that creates a representation for a ContactList. 
	public String toString() {
		return list.toString();
	}
	
	//An iterator() method that allows you to iterate through a ContactList. 
	//(You can implement your own or use the ArrayList’s own iterator). 
	Iterator<Contact> iterator(){
		if(list.size()== 0)
			 throw new NoSuchElementException();
		 for (Contact a : list) {
			 System.out.println(a);
		 }
		return list.iterator();
	}

}


public class Main {
	public static void main(String[] args) {
		
		Contact test = new Contact("Ari","Mermelstein", "7181111111" ,"2900 Beford Avenue" , "Brooklyn" , "NY");
		Contact testB = new Contact("Anyi","Chen", "9170002312" ,"123 4TH AVE" , "Mahattan" , "NY");
		Contact testC = new Contact("Bob","Smith", "9170987653" ,"123 1TH AVE" , "Mahattan" , "NY");
		Contact testD = new Contact("Anyi","Chen", "9170002312" ,"123 4TH AVE" , "Mahattan" , "NY");
		Contact testE = new Contact("Lob","Cab", "9170983422" ,"123 5TH AVE" , "Brooklyn" , "NY");
		ContactList<Contact> list = new ContactList<Contact>();
		
		System.out.println(list); //empty list
		
		list.add(test);
		list.add(testB);
		list.add(testC);
		list.add(test); //repeated, not add into the list and can't be print
		list.add(testD); //also repeated, not add into the list and can't be print
		list.add(testE);
		
		System.out.println("Number of total contact : " + list.size()); //print size
		System.out.println();
		
		System.out.println(list); //print the list sorted
		System.out.println();
		
		//find and print testB by last name
		System.out.println("Find testB by the last name Chen: \n" + list.findByLastName("Chen"));
		System.out.println();
		
		//find and print testA by phone number
		System.out.println("Find testA by the Phone Number: \n" + list.findByPhoneNumber("(718)111-1111"));
		System.out.println();
		
		//print a list of all contact with the last initial c
		System.out.println("All contact with last initial C: \n" + list.findAllByLastInitial('C'));
		System.out.println();
		
		//print a list of all contact in Broooklyn
		System.out.println("All contact in Brooklyn: \n" + list.findAllByCity("Brooklyn"));
		System.out.println();
		
		//remover test
		list.remove(test);
		System.out.println("List after remove: \n" + list);
		System.out.println();
		
		//get contact at index 2
		System.out.println("Contact at index 2: \n" + list.get(2));
		System.out.println();
		
		ContactList<Contact> list2 = new ContactList<Contact>();
		
		list2.add(test);
		list2.add(testB);
		list2.add(testC);
		list2.add(testE);
		
		//compare list2 to list, false
		System.out.println("Is list 2 the same as list?  \n" + list.equals(list2));
		System.out.println();
		
		//Convert list to string
		System.out.println("List to String: \n" + list.toString());
		System.out.println();
		
	}

}


public class Contact {
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	private String city;
	private String state;
	
	//constructor to initialize all the fields
	public Contact(String newFirst, String newLast, String newNum, String newAddress, String newCity, String newState) {
		firstName = newFirst;
		lastName = newLast;
		phoneNum = newNum;
		address = newAddress;
		city = newCity;
		state = newState;
		
		Format();
	}
	
	//formating phone numbers
	private void Format() {
		phoneNum = "(" + phoneNum.substring(0,3)+ ")" + phoneNum.substring(3,6) + "-" + phoneNum.substring(6);
	}
	
	//constructor that initializes only the name and phone number
	public Contact(String newFirst , String newLast) {
		firstName = newFirst;
		lastName = newLast;
	}
	
	//accessor (getter) methods for all of the data members
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	//an update method that allows the user to change all information. (They must change all of it). 
	public void update(String newFirst, String newLast, String newNum, String newAddress, String newCity, String newState) {
		firstName = newFirst;
		lastName = newLast;
		phoneNum = newNum;
		address = newAddress;
		city = newCity;
		state = newState;
		
		Format();
	}
	
	//An overridden equals() method that can tell if one Contact is the same as another. 
	public boolean equals(Object obj) {
		if(((Contact) obj).getFirstName().equals(firstName) && ((Contact) obj).getLastName().equals(lastName))
			return true;
		return false;
	}
	
	//overridden toString() method that creates a printable representation for a Contact object. 
	  public String toString() {

		  return firstName + " " + lastName + "      Phone number:" + phoneNum + "\n" + 
				 address + "\n" +
				 city + ", " + state + "\n";
	}
	
	//A comparison method
	public int compareTo(Contact another) {
		if(equals(another))
			return 0;
		if(lastName.compareTo(another.getLastName()) > 0)
			return 1;
			
		if(lastName.compareTo(another.getLastName())== 0)
			if(firstName.compareTo(another.getFirstName()) > 0)
				return 1;
		
		return -1;
		
	}
	
	

}

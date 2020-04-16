package projekt1;
import java.util.LinkedList;
import java.util.Scanner;


public class PeselHandler {
	public User ReadRecord() {
		Scanner input = new Scanner(System.in);
		User user = new User();
		
		System.out.print("Podaj nazwê miasta");
		user.City = input.nextLine();

		System.out.print("Podaj Imiê");
		user.FirstName = input.nextLine();

		System.out.print("Podaj nazwisko");
		user.LastName = input.nextLine();
				
		System.out.print("Podaj Pesel");		
		user.Pesel = input.nextLine();
		
		if(!CheckPesel(user.Pesel)) {
			System.out.print("Podano b³êdny pesel");		
			return null;
		}
		System.out.print("Dodano rekord");		
		return user;
	}
	
	public LinkedList<User> ReplaceRecord(User oldUser, User newUser, LinkedList<User> users) {
	    LinkedList<User> newUsersList = new LinkedList<User>();

		for(int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			
			if(user == oldUser) {
				newUsersList.add(newUser);
			}
			else {
				newUsersList.add(user);
			}
		}
		
		return newUsersList;
	}
	
	private boolean CheckPesel(String pesel) {
		if(pesel.length() != 11) { return false; }
		
		int sum = 0;
		int[] multipliers = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
		
		for(int i = 0; i < pesel.length() - 1; i++) {
			int number = Character.getNumericValue(pesel.charAt(i));
			sum += number * multipliers[i];		
		}
		
		if(sum >= 10) {
			sum = sum % 10;
		}
		int lastNumber = Character.getNumericValue(pesel.charAt(10));
		
		return lastNumber == (10 - sum);
	}
	
}

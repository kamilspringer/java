package projekt1;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Optional;

public class Main {

	public static void main(String[] args) throws IOException {
		PeselHandler peselHandler = new PeselHandler();
	    LinkedList<User> users = new LinkedList<User>();

		while(true) {
			User user =  peselHandler.ReadRecord();
			if(user == null) { continue; }
		    Optional<User> optionalUser = users.stream().filter(x -> x.Pesel.equals(user.Pesel)).findFirst();

		    if(optionalUser.isPresent()) {
		    	users = peselHandler.ReplaceRecord(optionalUser.get(), user, users);
		    }
		    else {   	
				users.add(user);
		    }
			new FileCreator().CreateFile(users);
		}

	}

}

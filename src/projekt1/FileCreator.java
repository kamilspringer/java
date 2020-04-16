package projekt1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class FileCreator {
	private static String FileName = "plik.txt";
	
	public void CreateFile(LinkedList<User> users) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter(this.FileName));
	    
	    for(int i = 0; i < users.size(); i++) {
	    	User user = users.get(i);
		    writer.write(user.City + " " + user.FirstName + " " + user.LastName + " " + user.Pesel + "\n");     
	    }
	    writer.close();
	}
}

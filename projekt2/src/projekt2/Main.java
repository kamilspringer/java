package projekt2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.*;

public class Main {

	public static void main(String[] args) throws IOException {
		GetWeather();
	}
	
	public static void GetWeather() throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.print("Witaj u¿ytkowniu, podaj nazwê miasta bez polskich znaków.");
		String city = input.nextLine();

	    URL urlForGetRequest = new URL("http://api.weatherstack.com/current?access_key=d98be29a6908c6e1625b1ebf093b1e20&query=" + city);
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");

	    int responseCode = conection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        
	        JSONObject json = new JSONObject(response.toString());
	        int temperature = json.getJSONObject("current").getInt("temperature");

	        System.out.println("W mieœcie " + city + " jest teraz " + temperature + " stopni.");

	    } else {
	        System.out.println("Upewnij siê, ¿e wpisa³eœ poprawnie nazwê miasta i sprawdz po³¹czenie z internetem.");
	    }
	}
}


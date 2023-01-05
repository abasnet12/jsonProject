package jsonproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//{
//"firstName": "Ambar",
//"lastname": "Basnet",
//"address": [
//    {
//        "street":"1000",
//        "city": "Springs",
//        "state": "CO"
//    },
//    {
//        "street":"5000",
//        "city": "Denver",
//        "state": "CO"
//    }
//
//
//]
//
//}
public class ReadFromJson {

	public static void main(String[] args) throws IOException, ParseException 
	{
		JSONParser jsonparser = new JSONParser();// need parser to parse the json object
		FileReader reader = new FileReader(".\\jsonFiles\\address.json");
		Object obj = jsonparser.parse(reader); // create java object varaible 'obj'
		
		//now covert thatinto json object
		JSONObject jsonObject =(JSONObject) obj;
		
		
		//casting jsonObject to string
		String firstName = (String) jsonObject.get("firstName");
		String lastName = (String) jsonObject.get("lastName");

		System.out.println("FirstName: " + firstName);
		System.out.println("lastName: " + lastName);
		
		//Extract the address array from json object
		JSONArray array = (JSONArray) jsonObject.get("address");
		
		for(int i = 0; i < array.size(); i++)
		{
			JSONObject address = (JSONObject) array.get(i);
			String street = (String)address.get("street");
			String city = (String)address.get("city");
			String state = (String)address.get("state");
			String country = (String)address.get("country");
			
			System.out.println("Address of: " + i);
			
			System.out.println("street: " + street);
			System.out.println("city: " + city);
			System.out.println("state: " + state);
			System.out.println("\"country:\" " + country);
		}
	}//main

}// ReadFromJson class

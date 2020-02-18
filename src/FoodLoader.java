import java.util.Scanner;
import java.io.*;

public class FoodLoader{

	private static final int maxFileLines = 100;
	
	// Bronze
	// Load the String of Food data and return a fully initialized Food object (including ingredients)
	public static Food parseString(String foodAsString){
		Food foodItem = null;



		return foodItem; // change this to return the initialized object
	}

	// given a specified file, load it and parse each line into a Food[] type object. Be sure to handle
	// any exceptions. 
	public static Food[] loadFile(String fileName){
		// Return data
		Food[] foodList = new Food[maxFileLines];
		int count =0;

		BufferedReader finleIn;
		String lineIn;
		Scanner lineScanner;

		try{
			finleIn = new BufferedReader(new FileReader(fileName));
			lineIn = finleIn.readLine();
			while (lineIn != null){
				count++;
				
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}




		return foodList; // return an initialized food array. 
	}

}
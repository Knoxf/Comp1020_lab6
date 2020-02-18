// An Ingredient object contains information about one component of a 
// Food object. Later we will add nutritional information to this. 
public class Ingredient{
	// instance variables
	private String name; 
	private double amount; // in grams

	// Nutrition
	private double servingSize;
	// In grams. Should provide us with calories.  
	private double protein;
	private double fat;
	private double carbs;

	private double caloriesPerCarb = 4.0;
	private double caloriesPerProtein = 4.0;
	private double caloriesPerFat = 9.0;

	// Base constructor to set both variables, Amount is in grams
	public Ingredient(String newName, double newAmount){
		name = newName;
		amount = newAmount;
	}

	// Note: The Nutrition information is relative to the serving size specified (in grams)
	public Ingredient(String newName, double newAmount, double newServingSize,
				double setProtein, double setFat, double setCarbs){
		servingSize = newServingSize;
		protein = setProtein;
		fat = setFat;
		carbs = setCarbs;
	}

	// Proportion of a serving amount / serving size. 
	// The amount over the serving size, or 0 if it is undefined. 
	public double getProportion(){
		if( servingSize != 0)
			return amount / servingSize;
		else{
			System.out.println("Serving size not defined");
			return 0;
		}
	}

	// Calculate calories Per serving
	public double getCaloriesPerServing(){
		double total = protein * caloriesPerProtein + fat * caloriesPerFat + carbs * caloriesPerCarb;
		return total; 
	}

	// Total calories given the amount of food defined in this object. 
	public double getCaloriesAbsolute(){
			return getProportion() * getCaloriesPerServing();
	}

	public String getNutrition(){
		return name + " Serving size: " + servingSize + " Protein: " + protein + " Fat: " + fat + " Carbs: " + carbs;
	}

	// Returns the name of the Ingredient
	public String toString(){
		return name;
	}
}
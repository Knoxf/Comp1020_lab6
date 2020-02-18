public class VendingMachine {
    // A2 Bronze - Instance
    private Food[][] foods;

    // A2 Bronze - Static
    //private static int maxFoods = 10;
    private static int maxFoods_rows = 5;
    private static int maxFoods_cols = 4;

    public VendingMachine(){
        // foods = new Food[maxFoods];
        foods = new Food[maxFoods_cols][maxFoods_rows];
    }

    // Return the count of all valid food objects in the machine.
    public int count(){
          /*
            int count = 0;
            for(int i = 0; i < foods.length; i++){
                  if( foods[i] != null){
                        count++;
                  }
            }
            return count;
           */

        int count = 0;
        for(int i=0;i<foods.length;i++){
            for(int j=0;j<foods[i].length;j++){
                if(foods[i][j] != null){
                    count++;
                }
            }
        }
        return count;
    }

    // returns the size of the current array, or 0 if it is null
    public int size(){
        if(foods == null)
            return 0;
        else
            return foods.length;
    }

    // Add food to the array at a given index if it is valid and not already assigned
    // Return true if you added the new food successfully and false otherwise.
    public boolean addFood(Food newFood, int row, int col){
        boolean returnVal = false;
        // if spot is valid, and empty, add the food and return true
        // otherwise return false.
          /*
            if(index >= 0 && index < maxFoods){
                  if(foods[index] == null){
                        foods[index] = newFood;
                        returnVal = true; // was added.
                  }
            }
            return returnVal;
           */
        if(row>=0 && row<foods.length && col>=0 && col<foods[row].length){
            if(foods[row][col] == null){
                foods[row][col] = newFood;
                returnVal = true;
            }
        }
        return returnVal;
    }

    // To String for the Vending Machine - prints out all foods including the index of the array they are stored in.
    public String toString(){
        String st = "Vending Machine Interface:";
        st += "\nContains: " + count() + " Food Items";
            /*
            for(int i = 0; i < foods.length; i++){
                  st += "\nItem " + i + " is " ;
                  if( foods[i] != null){
                        st += foods[i].toString();
                  }else{
                        st += "Empty";
                  }
            }
            return st;
             */

        for(int i=0;i<foods.length;i++){
            for(int j=0;j<foods[i].length;j++){
                st += "\nItem" + "[" + i  + "," + j + "]";
                if(foods[i][j] != null){
                    st += foods[i][j].toString();
                }else{
                    st += "Empty";
                }
            }
        }
        return st;
    }

    public static void main(String[] args){
        // Run tests of individual objects
        //      testLab1(); // Silver
        //      testLab2(); // Silver
        testLab3(); // Bronze
        //      testLab3_Silver(); // Silver
    }

    // More tests that test the new features in Lab 3
    public static void testLab3(){
        // Create the vending machine object to store our test objects.
        VendingMachine vm = new VendingMachine();
        // adding 2d array of Food objects to VendingMachine
        // update methods to accept 2d location in the machine,

        // ======= Creating Test Food Items =======
        // Apple Food Test Data
        Ingredient[] appleIng = new Ingredient[2];    // Ingredients array
        appleIng[0] = new Ingredient("Apple Junk", 0.5); // add ingredients
        appleIng[1] = new Ingredient("Redness", 0.3);
        Food appleFood = new Food("Apple", 120, 2, appleIng); // create food object

        // Banana Food Test Data
        Ingredient[] bananaIng = new Ingredient[2];
        bananaIng[0] = new Ingredient("Banana Mush", 1.0);
        bananaIng[1] = new Ingredient("Banana Skin", 0.5);
        Food bananaFood = new Food("Banana", 180, 1, bananaIng);

        // Another Snack
        Ingredient[] snackIngredients = new Ingredient[3];
        snackIngredients[0] = new Ingredient("Mushy Stuff", 0.5);
        snackIngredients[1] = new Ingredient("Tasty Snack", 0.3);
        snackIngredients[2] = new Ingredient("Crispy Bits", 0.1);
        Food food3 = new Food("Test Snack", 123, 9, snackIngredients);

        // ======= Testing Adding Food Items =======

        System.out.println("Testing Count: (Should be 0) " + vm.count() + "\n");

        // These return boolean however if we don't assign the value it is lost.
        // Adding and testing Apple

        boolean addFlag = false;
        // Add apple
        addFlag = vm.addFood( appleFood, 0, 3);
        // Check if it worked & print output
        if(addFlag){
            System.out.println("Food Added Successfully to array at [0,3] "  + appleFood.toString());
        }else{
            System.out.println("Something went wrong when adding: " + appleFood.toString());
        }

        System.out.println("Testing Count: (Should be 1) " + vm.count() + "\n");

        // Adding Banana
        addFlag = vm.addFood(bananaFood, 4,3);
        // testing and output
        if(addFlag){
            System.out.println("Food Added Successfully to array at [4,3] "  + bananaFood.toString());
        }else{
            System.out.println("Something went wrong when adding: " + bananaFood.toString());
        }


        System.out.println("Testing Count: (Should be 2) " + vm.count() + "\n");

        // Adding Snack
        addFlag = vm.addFood( food3 , 2,0);
        // Testing output
        if(addFlag){
            System.out.println("Food Added Successfully to array at [2,0]: " + food3.toString());
        }else{
            System.out.println("Something went wrong when adding: " + food3.toString());
        }

        System.out.println("Testing Count: (Should be 3) " + vm.count() + "\n");

        // Print out the whole VendingMachine
        System.out.println("\n-----------------------------------\n" + vm.toString());


        // Silver:
        // or add by a single index and map that to the 2d location
        // still support testLab2 & 1


        // Gold:

        // Move the main and testMethods into a new class (LabsTest.java) to seperate the tests from the Object functionality of the Vending Machine
        // Fully test your new classes including indexes out of bounds for both add methods. This should include both indexes as well as cols and rows
        // and should check adding both negative values (-1) and positive values (eg maxFoods_rows and maxFoods_cols passed as the row and col parameter should both fail. )

    }
/*
      public static void testLab3_Silver(){
            System.out.println("++++++++++++++ Testing Lab3 - Silver +++++++++++++++++++");
            System.out.println("Adding to a 2d array by index");
                        // Create the vending machine object to store our test objects.
            VendingMachine vm = new VendingMachine();
            System.out.println("Row 0, Col 3 should be index 3 RC:[" + vm.getRow(3) + ", " + vm.getCol(3) + "] index from rc " + vm.rowsColsToIndex(0,3));
            System.out.println("Row 2, Col 0 should be index 8 RC:[" + vm.getRow(8) + ", " + vm.getCol(8) + "] index from rc " + vm.rowsColsToIndex(2,0));
            System.out.println("Row 4, Col 3 should be index 19 RC:[" + vm.getRow(19) + ", " + vm.getCol(19) + "] index from rc " + vm.rowsColsToIndex(4,3));
            // adding 2d array of Food objects to VendingMachine
            // update methods to accept 2d location in the machine,
            // ======= Creating Test Food Items =======
            // Apple Food Test Data
            Ingredient[] appleIng = new Ingredient[2];    // Ingredients array
            appleIng[0] = new Ingredient("Apple Junk", 0.5); // add ingredients
            appleIng[1] = new Ingredient("Redness", 0.3);
            Food appleFood = new Food("Apple", 120, 2, appleIng); // create food object
            // Banana Food Test Data
            Ingredient[] bananaIng = new Ingredient[2];
            bananaIng[0] = new Ingredient("Banana Mush", 1.0);
            bananaIng[1] = new Ingredient("Banana Skin", 0.5);
            Food bananaFood = new Food("Banana", 180, 1, bananaIng);
            // Another Snack
            Ingredient[] snackIngredients = new Ingredient[3];
            snackIngredients[0] = new Ingredient("Mushy Stuff", 0.5);
            snackIngredients[1] = new Ingredient("Tasty Snack", 0.3);
            snackIngredients[2] = new Ingredient("Crispy Bits", 0.1);
            Food food3 = new Food("Test Snack", 123, 9, snackIngredients);
            // ======= Testing Adding Food Items =======
            System.out.println("Testing Count: (Should be 0) " + vm.count() + "\n");
            // These return boolean however if we don't assign the value it is lost.
            // Adding and testing Apple
            boolean addFlag = false;
            // Add apple
            addFlag = vm.addFood( appleFood, 3);
            // Check if it worked & print output
            if(addFlag){
                  System.out.println("Food Added Successfully to array at [0,3] by index 3"  + appleFood.toString());
            }else{
                  System.out.println("Something went wrong when adding: " + appleFood.toString());
            }
            System.out.println("Testing Count: (Should be 1) " + vm.count() + "\n");
            // Adding Banana
            addFlag = vm.addFood(bananaFood, 4,3);
            // testing and output
            if(addFlag){
                  System.out.println("Food Added Successfully to array at [4,3] by index 19"  + bananaFood.toString());
            }else{
                  System.out.println("Something went wrong when adding: " + bananaFood.toString());
            }
            System.out.println("Testing Count: (Should be 2) " + vm.count() + "\n");
            // Adding Snack
            addFlag = vm.addFood( food3 , 2,0);
            // Testing output
            if(addFlag){
                  System.out.println("Food Added Successfully to array at [2,0] by index 8 " + food3.toString());
            }else{
                  System.out.println("Something went wrong when adding: " + food3.toString());
            }
            System.out.println("Testing Count: (Should be 3) " + vm.count() + "\n");
            // Print out the whole VendingMachine
            System.out.println("\n-----------------------------------\n" + vm.toString());
      }
*/
/*
      // Your tests for lab 2.
      // Covers - Adding Foods to the Vending Machine.
      public static void testLab2(){
            VendingMachine vm = new VendingMachine();
            // String newName, int newCalories, int newCost){
            // Apple Food Test Data
            Ingredient[] appleIng = new Ingredient[2];    // Ingredients array
            appleIng[0] = new Ingredient("Apple Junk", 0.5); // add ingredients
            appleIng[1] = new Ingredient("Redness", 0.3);
            Food appleFood = new Food("Apple", 120, 2, appleIng); // create food object
            // Banana Food Test Data
            Ingredient[] bananaIng = new Ingredient[2];
            bananaIng[0] = new Ingredient("Banana Mush", 1.0);
            bananaIng[1] = new Ingredient("Banana Skin", 0.5);
            Food bananaFood = new Food("Banana", 180, 1, bananaIng);
            // ============= These should add new food =============
            // These return boolean however if we don't assign the value it is lost.
            boolean addFlag = false;
            addFlag = vm.addFood(appleFood, 3);
            if(addFlag){
                  System.out.println("Food Added Successfully: " + appleFood.toString());
            }else{
                  System.out.println("Something went wrong when adding: " + appleFood.toString());
            }

            System.out.println("Testing Count: " + vm.coun();)
            // Recycle the flag
            addFlag = vm.addFood(bananaFood, 6);
            if(addFlag){
                  System.out.println("Food Added Successfully: " + bananaFood.toString());
            }else{
                  System.out.println("Something went wrong when adding: " + bananaFood.toString());
            }
            System.out.println(vm.toString());
            // ============= These should Fail to add new food =============
            Food invalidFood = new Food("Invalid", 0, 0, new Ingredient[0]); // Note: We are adding an empty array so that it doesn't crash if it is accessed.
            // Add to existing index, this should NOT work
            addFlag = vm.addFood(invalidFood, 6);
            if(addFlag){
                  System.out.println("Should not have overwritten the old food object with: " + invalidFood.toString());
            }else{
                  System.out.println("Successfully rejected adding to an occupied spot in the array: " + invalidFood.toString());
            }
            // Add to existing index again, this should NOT work
            addFlag = vm.addFood(invalidFood, 3);
            if(addFlag){
                  System.out.println("Should not have overwritten the old food object with: " + invalidFood.toString());
            }else{
                  System.out.println("Successfully rejected adding to an occupied spot in the array: " + invalidFood.toString());
            }
             // Add to out of bounds index, this should NOT work
            // Add to existing index again, this should NOT work
            addFlag = vm.addFood(invalidFood, vm.size());
            if(addFlag){
                  System.out.println("Should not return true when adding to an invalid index (-1) " + vm.size() );
            }else{
                  System.out.println("Successfully rejected adding to index " + vm.size() );
            }
            // Add to out of bounds index, this should NOT work
            addFlag = vm.addFood(invalidFood, -1);
            if(addFlag){
                  System.out.println("Should not return true when adding to an invalid index (-1) " + invalidFood.toString());
            }else{
                  System.out.println("Successfully rejected adding to index -1: " + invalidFood.toString());
            }
      }
      // Leftover from lab 1.
      // All your tests should still work
      // Covers - Basic Ingredients arrays & objects
      // Basic Food objects
      // adding ingredients to Food
      public static void testLab1(){
            // String newName, int newCalories, int newCost){
            Ingredient[] appleIng = new Ingredient[2];
            appleIng[0] = new Ingredient("Apple Junk", 0.5);
            appleIng[1] = new Ingredient("Redness", 0.3);
            Food food1 = new Food("Apple", 120, 2, appleIng);
            Ingredient[] bananaIng = new Ingredient[2];
            bananaIng[0] = new Ingredient("Banana Mush", 1.0);
            bananaIng[1] = new Ingredient("Banana Skin", 0.5);
            Food food2 = new Food("Banana", 180, 1, bananaIng);
            // setIngredients(String[] newIngredients){
            food2.setIngredients(bananaIng);
            Food.getCount();
            System.out.println(food1.toString() + "\n" + food1.getIngredients() + '\n');
            System.out.println(food2.toString() + "\n" + food2.getIngredients());
            // Silver
            Ingredient newIng = new Ingredient("Yellow Banana Outer Shell", 0.2);
            food2.addIngredient(newIng);
            System.out.println(food2.toString() + "\n" + food2.getIngredients());
            // Part g
            Ingredient i1 = new Ingredient("Mushy Stuff", 0.5);
            Ingredient i2 = new Ingredient("Tasty Snack", 0.3);
            Ingredient i3 = new Ingredient("Crispy Bits", 0.1);
            Food food3 = new Food("Test Snack", 123, 9, new Ingredient[0]);
            System.out.println(food3.toString() + "\n" + food3.getIngredients());
            food3.addIngredient(i1);
            System.out.println(food3.toString() + "\n" + food3.getIngredients());
            food3.addIngredient(i2);
            System.out.println(food3.toString() + "\n" + food3.getIngredients());
            food3.addIngredient(i3);
            System.out.println(food3.toString() + "\n" + food3.getIngredients());

      }
      */
}

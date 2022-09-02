import Service.CartService;
import Service.MenuService;

import java.util.Scanner;

public class FastFoodPlace {
    public static void main(String[] args){
        boolean insideFastFoodMachine = true;
        boolean insideMenu = false;
        MenuService ms = new MenuService();
        CartService cs = new CartService();
        while(insideFastFoodMachine) {
            System.out.println("Select an option, please: view food menu / view prices /  advanced options / quit: ");
            Scanner customerInput = new Scanner(System.in);
            String readLine = customerInput.nextLine();
            if(readLine.equals("quit")){
                insideFastFoodMachine = false;
                insideMenu = false;
            } else if (readLine.equals("advanced options")) {
                insideFastFoodMachine = false;
                insideMenu = true;
            } else if (readLine.equals("view food menu")) {
                // display the menu(done), group by price in the Menu entity [**Add a product_price column in Menu table**]
                System.out.println(ms.getAllFoodItems());
                insideMenu = true;
            }else if(readLine.equals("view prices")){
                System.out.println("Please add a product name from our Menu: ");
                String input = customerInput.nextLine();
                System.out.println(ms.getAllFoodPricesByName(input));
            }
        }
        while(insideMenu) {
            System.out.println("Select an option, please: add a food / update my cart / view my cart / finish: ");
            Scanner customerInput = new Scanner(System.in);
            String line = customerInput.nextLine();
            if (line.equals("finish")) {
                insideMenu = false;
            }
            else if (line.equals("add a food")) {
                // add a food item in the Cart class
                System.out.println("Please add an ID associated with item from our Menu: ");
                int idInput = customerInput.nextInt();
                String foodInput = customerInput.nextLine();
                System.out.println("Please add a food item from our Menu: ");
                cs.addItems(idInput, foodInput);
            } else if (line.equals("update my cart")) {
                // update an item and/or delete an item in the Cart Class [UPDATE, DELETE sql functions]
            } else if (line.equals("view my cart")) {
                // display the newly created cart (maybe in a new Customer entity?) --> Did it in the Cart entity
                System.out.println(cs.getAllFoodItemsFromCart());
                // having issues viewing my cart
                // I am unable to view the added items.
            }
        }

    }
}
// ./gradlew shadowJar
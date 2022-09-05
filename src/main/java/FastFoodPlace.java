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
            System.out.println("Select an option, please:" + "\n" +
                    "-------------------------------------------------------------------------"+ "\n" +
                    "view food menu | advanced options | administrative options | quit: "+ "\n" +
                    "-------------------------------------------------------------------------");
            Scanner customerInput = new Scanner(System.in);
            String readLine = customerInput.nextLine();
            if(readLine.equals("quit")){
                insideFastFoodMachine = false;
                insideMenu = false;
            } else if (readLine.equals("advanced options")) {
                insideFastFoodMachine = false;
                insideMenu = true;
            } else if (readLine.equals("view food menu")) {
                System.out.println(ms.getAllFoodItems());
                insideMenu = true;
            }else if(readLine.equals("administrative options")){
                System.out.println("Please type a Product ID: ");
                int input = customerInput.nextInt();
                ms.updateAProduct(input);
            }
        }
        while(insideMenu) {
            System.out.println("Select an option: please:" + "\n" +
                    "---------------------------------------------------------------------------------"+ "\n" +
                    "add a food item | remove a food item | view my cart | view total price | finish: "+ "\n" +
                    "---------------------------------------------------------------------------------");
            Scanner customerInput = new Scanner(System.in);
            String line = customerInput.nextLine();
            if (line.equals("finish")) {
                insideMenu = false;
            }
            else if (line.equals("add a food item")) {
                // add a food item in the Cart class
                System.out.println("Please type an ID associated with the item from our Menu: ");
                int idInput = customerInput.nextInt();
                customerInput.nextLine();
                System.out.println("Please type a food item from our Menu: ");
                String foodInput = customerInput.nextLine();
                customerInput.nextLine();
                System.out.println("Please type the price from our Menu: ");
                double priceInput = customerInput.nextDouble();
                cs.addItems(idInput, foodInput, priceInput);
            } else if (line.equals("remove a food item")) {
                System.out.println("Please type an ID associated with the item you want to remove: ");
                int idInput = customerInput.nextInt();
                cs.removeItems(idInput);
            } else if (line.equals("view my cart")) {
                System.out.println(cs.getAllFoodItemsFromCart());
            }else if(line.equals("view total price")){
                System.out.println(cs.getTotalPrice());
            }
        }

    }
}
// ./gradlew shadowJar
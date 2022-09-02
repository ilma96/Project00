package Service;

import DAO.CartRepository;
import Model.Cart;

import java.util.List;

public class CartService {
    CartRepository cr;
    MenuService ms;
    public CartService(){
        cr = new CartRepository();
        ms = new MenuService();
    }

    public List<Cart> getAllFoodItemsFromCart(){
        return cr.getAllFoodItemsFromCart();
    }
    public void addItems(int cartID, String foodItem){
        Cart existingItems = cr.getFoodItemByName(foodItem); // if I haven't added the same item
        //List<Menu> idExists = cr.getAllFoodItemsByProductID(num);
        if(existingItems == null) {   //&& idExists != null
            Cart newItem = new Cart(cartID, foodItem);
            cr.addItems(newItem);
        }

    }
    public void removeItems(int cartID, String itemName, int itemPrice){

    }
}


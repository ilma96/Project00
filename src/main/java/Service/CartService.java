package Service;

import DAO.CartRepository;
import DAO.MenuRepository;
import Model.Cart;


import java.util.List;

public class CartService {
    CartRepository cr;
    public CartService(){
        cr = new CartRepository();
    }
//    public List<Cart> joinCartIDAndProductID(){
//        return cr.joinCartIdAndProductId();
//    }
    public List<Cart> getAllFoodItemsFromCart(){
            return cr.viewItemIfExists();
    }
    public List<Cart> getTotalPrice(){
        return cr.getTotalPrice();
    }
    public void addItems(int cartID, double foodPrice, String foodItem){
            Cart newItem = new Cart(cartID, foodPrice, foodItem);
            cr.addItems(newItem);
    }
    public void removeItems(int cartID){
        //List<Cart> existingItems = cr.viewItemIfExists();
        // if the items exists in the cart, then remove
            Cart removeItem = new Cart(cartID);
            cr.removeItems(removeItem);

    }
}


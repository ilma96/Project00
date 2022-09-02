package Model;

import java.text.DecimalFormat;

public class Cart {
    private int cartID;
    private String foodName;
    private int foodPrice;

    public Cart(String foodName) {
        this.foodName = foodName;
    }

    public Cart(int cartID, String foodName) {
        this.cartID = cartID;
        this.foodName = foodName;
    }

    public Cart(int cartID, String foodName, int foodPrice) {
        this.cartID = cartID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    @Override
    public String toString() {
        DecimalFormat prettyFormat = new DecimalFormat("#.00");
        return "Your Food Cart {" +
                "Cart ID: " + cartID +
                ", Food Name: " + foodName + "  Price: $" + prettyFormat.format(foodPrice)
                + '\'' +
                "}" + "\n";
    }
}

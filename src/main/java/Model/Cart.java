package Model;

import java.text.DecimalFormat;

public class Cart {
    private int cartID;
    private String foodName;
    private double foodPrice;

    public Cart(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Cart(int cartID, double foodPrice, String foodName) {
        this.cartID = cartID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public Cart(int cartID,  String foodName, double foodPrice) {
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

    public double getFoodPrice() {
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

package Model;

import java.text.DecimalFormat;

public class Price {
    private double foodPrice;
    private String foodName;

    public Price(double foodPrice, String foodName) {
        this.foodPrice = foodPrice;
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        DecimalFormat prettyFormat = new DecimalFormat("#.00");
        return "The Price for the selected food item: " +
                " $" + prettyFormat.format(foodPrice) +
                " (" + foodName + ")";
    }
}

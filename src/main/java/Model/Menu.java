package Model;

import java.text.DecimalFormat;

public class Menu {
    private int productID;
    private String productName;
    private String productCategory;
    private int menuID;
    private int productPrice;

    public Menu(String productName) {
        this.productName = productName;
    }

    public Menu(int productID, String productName, int productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Menu(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Menu(int productID, String productName, String productCategory, int menuID, int productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.menuID = menuID;
        this.productPrice = productPrice;
    }


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        DecimalFormat prettyFormat = new DecimalFormat("#.00");
        return "Our Food Menu {" + "Product ID: " + productID + "  Product Name: " + productName + "  Category: "
                + productCategory + "  Menu ID: " + menuID + "  Price: $" + prettyFormat.format(productPrice)
                + '\'' + "}" + "\n";
    }
}

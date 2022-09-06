package DAO;

import Model.Cart;
import Model.Menu;
import Model.Price;
import Util.ConnectionsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    Connection c = ConnectionsUtil.getConnection();

    public void addItems(Cart item){
        try{
            PreparedStatement stmt = c.prepareStatement("insert into Cart(cart_id, food_name, item_price)"
                    + "values (?,?,?)");
            stmt.setInt(1, item.getCartID());
            stmt.setString(2, item.getFoodName());
            stmt.setDouble(3, item.getFoodPrice());
            stmt.executeUpdate();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    public void removeItems(Cart item){
        try{
            PreparedStatement stmt = c.prepareStatement("Delete from Cart where cart_id = ?");
            stmt.setInt(1, item.getCartID());
            stmt.executeUpdate();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    public List<Cart> viewItemIfExists(){
        List<Cart> itemExists = new ArrayList<>();
        try{
            Statement cartStatement = c.createStatement();
            ResultSet rs = cartStatement.executeQuery("Select * From Cart c\n" +
                    "Where exists (Select product_name, product_price " +
                    "From Menu m Where m.product_id = c.cart_id and m.product_price = c.item_price)");
            // SQL statement to check if an item added in Cart exists in the Menu or not
            while(rs.next()) {
                Cart displayFood = new Cart(rs.getInt("cart_id"), rs.getString("food_name"),
                        rs.getDouble("item_price"));
                itemExists.add(displayFood);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return itemExists;
    }

    public List<Price> getTotalPrice(){
        List<Price> totalPrice = new ArrayList<>();
        try{
            Statement cartStatement = c.createStatement();
            ResultSet rs = cartStatement.executeQuery("Select sum(item_price) as item_price " +
                    "from Cart Where exists (Select product_price " +
                    "From Menu m Where m.product_id = Cart.cart_id and m.product_price = Cart.item_price)");
            while(rs.next()){
                Price displayPrice = new Price(rs.getDouble("item_price"));
                totalPrice.add(displayPrice);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return totalPrice;
    }

}



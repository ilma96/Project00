package DAO;

import Model.Cart;
import Model.Menu;
import Util.ConnectionsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    Connection c = ConnectionsUtil.getConnection();

    public void addItems(Cart item){
        try{
            PreparedStatement stmt = c.prepareStatement("insert into Cart(cart_id, item_price, food_name)" + "values (?,?,?)");
            stmt.setInt(1, item.getCartID());
            stmt.setDouble(2, item.getFoodPrice());
            stmt.setString(3, item.getFoodName());
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
            ResultSet rs = cartStatement.executeQuery("Select cart_id, food_name, item_price From Cart c\n" +
                    "Where exists (Select product_name From Menu m Where m.product_id = c.cart_id)");
            // SQL statement to check if an item added in Cart exists in the Menu or not
            while(rs.next()) {
                Cart displayFood = new Cart(rs.getInt("cart_id"), rs.getString("food_name"), rs.getDouble("item_price"));
                itemExists.add(displayFood);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return itemExists;
    }

    public List<Cart> getTotalPrice(){
        List<Cart> totalPrice = new ArrayList<>();
        try{
            Statement cartStatement = c.createStatement();
            ResultSet rs = cartStatement.executeQuery("Select SUM(item_price) from Cart");
            while(rs.next()){
                Cart displayPrice = new Cart(rs.getDouble("item_price"));
                totalPrice.add(displayPrice);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return totalPrice;
    }

}



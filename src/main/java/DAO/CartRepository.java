package DAO;

import Model.Cart;
import Model.Menu;
import Util.ConnectionsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    Connection c = ConnectionsUtil.getConnection();

    public List<Menu> getAllFoodItemsByProductID(int id){
        List<Menu> foodItems = new ArrayList<>();
        try{
            PreparedStatement stmt = c.prepareStatement("Select * from Menu where product_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Menu displayItem = new Menu(rs.getInt("product_id"), rs.getString("product_name"),
                        rs.getInt("product_price"));
                foodItems.add(displayItem);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return foodItems;
    }
    public Cart getFoodItemByName(String name){
        try{
            PreparedStatement stmt = c.prepareStatement("Select * From Cart where food_name = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cart items = new Cart(rs.getString("food_name"));
                return items;
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }
    public void addItems(Cart item){
        try{
            PreparedStatement stmt = c.prepareStatement("insert into Cart(cart_id, food_name)" + "values (?,?)");
            stmt.setInt(1, item.getCartID());
            stmt.setString(2, item.getFoodName());
            stmt.executeUpdate();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    public void removeItems(Cart item){

    }
    public List<Cart> getAllFoodItemsFromCart(){
        List<Cart> theCart = new ArrayList<>();
        try{
            Statement cartStatement = c.createStatement();
            ResultSet rs = cartStatement.executeQuery("Select * From Cart");
            while(rs.next()){
                Cart displayFood = new Cart(rs.getInt("cart_id"), rs.getString("food_name"), rs.getInt("item_price"));
                theCart.add(displayFood);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return theCart;
    }
}


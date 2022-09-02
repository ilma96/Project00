package DAO;

import Model.Menu;
import Util.ConnectionsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    Connection c;
    public MenuRepository(){
        c = ConnectionsUtil.getConnection();
    }
    public List<Menu> getAllFoodItems(){
        List<Menu> theMenu = new ArrayList<>();
        try{
            Statement menuStatement = c.createStatement();
            ResultSet rs = menuStatement.executeQuery("Select * From Menu");
            while(rs.next()){
                Menu displayFood = new Menu(rs.getInt("product_id"), rs.getString("product_name"),
                        rs.getString("product_category"), rs.getInt("menu_id"),
                        rs.getInt("product_price"));
                theMenu.add(displayFood);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return theMenu;
    }

    public List<Menu> getAllFoodPricesByName(String foodName){
        List<Menu> foodItems = new ArrayList<>();
        try{
            PreparedStatement stmt = c.prepareStatement("Select * From Menu where product_name = ?");
            stmt.setString(1, foodName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Menu m = new Menu(rs.getString("product_name"), rs.getInt("product_price"));
                foodItems.add(m);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return foodItems;
    }
}


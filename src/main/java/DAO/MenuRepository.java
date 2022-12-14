package DAO;

import Model.Menu;
import Model.Price;
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
                        rs.getString("product_category"), rs.getDouble("product_price"));
                theMenu.add(displayFood);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return theMenu;
    }

    public void updateMenu(Menu item){
        try{
            PreparedStatement stmt = c.prepareStatement("Update Menu Set product_name = 'Chana Masala', " +
                    "product_category = 'Savory', product_price = 12.00 Where product_id = ?");
            stmt.setInt(1, item.getProductID());
            stmt.executeUpdate();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}


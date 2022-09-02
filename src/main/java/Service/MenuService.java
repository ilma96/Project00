package Service;

import DAO.MenuRepository;
import Model.Menu;

import java.util.List;

public class MenuService {
    MenuRepository mr;
    public MenuService(){
        mr = new MenuRepository();
    }

    public List<Menu> getAllFoodItems(){
        return mr.getAllFoodItems();
    }

    public List<Menu> getAllFoodPricesByName(String name){
        return mr.getAllFoodPricesByName(name);
    }
}

package Service;

import DAO.MenuRepository;
import Model.Menu;
import Model.Price;

import java.util.List;

public class MenuService {
    MenuRepository mr;
    public MenuService(){
        mr = new MenuRepository();
    }

    public List<Menu> getAllFoodItems(){
        return mr.getAllFoodItems();
    }

    public void updateAProduct(int id){
        Menu updatedRow = new Menu(id);
        mr.updateMenu(updatedRow);
    }
}

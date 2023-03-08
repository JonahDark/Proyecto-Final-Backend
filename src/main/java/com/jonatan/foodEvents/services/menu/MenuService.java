package com.jonatan.foodEvents.services.menu;

import com.jonatan.foodEvents.entities.Menu;
import com.jonatan.foodEvents.requests.CrearMenuRequest;

import java.util.List;

public interface MenuService {
    List<Menu>getAllMenus();
    Menu createMenu(CrearMenuRequest request);
    Menu editMenu(Long id_menu, CrearMenuRequest request);
    void deleteMenu(Long id_menu);


}

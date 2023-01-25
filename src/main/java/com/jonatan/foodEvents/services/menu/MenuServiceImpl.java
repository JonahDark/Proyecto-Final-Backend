package com.jonatan.foodEvents.services.menu;

import com.jonatan.foodEvents.entities.Menu;
import com.jonatan.foodEvents.repositories.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;
    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }
}

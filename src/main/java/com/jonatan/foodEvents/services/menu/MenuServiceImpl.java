package com.jonatan.foodEvents.services.menu;

import com.jonatan.foodEvents.entities.Menu;
import com.jonatan.foodEvents.repositories.MenuRepository;
import com.jonatan.foodEvents.requests.CrearMenuRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;


    @Override
    public void deleteMenu(Long id_menu) {
        Optional<Menu> optionalMenu = menuRepository.findById(id_menu);
        if (optionalMenu.isPresent()) {
            menuRepository.deleteById(id_menu);
        }else {
            throw new EntityNotFoundException("No existe éste menú con éste ID");
        }
    }

    @Override
    public Menu editMenu(Long id_menu, CrearMenuRequest request) {
        Optional<Menu> optionalMenu = menuRepository.findById(id_menu);
        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            menu.setFoto(request.getFoto());
            menu.setPrecio_menu(request.getPrecio_menu());
            menu.setNombre(request.getNombre());
            menu.setTipo(request.getTipo());
            menu.setPrecio_menu_alergeno_infantil(request.getPrecio_menu_alergeno_infantil());
            menu.setPrecio_menu_alergeno(request.getPrecio_menu_alergeno());
            menu.setPrecio_menu_infantil(request.getPrecio_menu_infantil());
            return menuRepository.save(menu);
        } else {
            throw new EntityNotFoundException("No existe éste menú con éste ID");
        }

    }

    @Override
    public Menu createMenu(CrearMenuRequest request) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(request, menu);
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }
}

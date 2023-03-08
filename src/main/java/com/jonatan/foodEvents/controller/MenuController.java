package com.jonatan.foodEvents.controller;

import com.jonatan.foodEvents.entities.Menu;
import com.jonatan.foodEvents.repositories.MenuRepository;
import com.jonatan.foodEvents.requests.CrearMenuRequest;
import com.jonatan.foodEvents.services.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;


    @GetMapping("/getAllMenus")
    public ResponseEntity<List<Menu>> getMenus() {
        return ResponseEntity.ok(menuService.getAllMenus());
    }


    @PostMapping("/createMenu")
    public ResponseEntity<Menu> createMenu(@RequestBody CrearMenuRequest request) {
        return ResponseEntity.ok(menuService.createMenu(request));
    }

    @PatchMapping("/editMenu/{id_menu}")
    public ResponseEntity<Menu> editMenu(@PathVariable Long id_menu, @RequestBody CrearMenuRequest request) {
        return ResponseEntity.ok(menuService.editMenu(id_menu, request));
    }

    @DeleteMapping("/deleteMenu/{id_menu}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id_menu){
        menuService.deleteMenu(id_menu);
        return ResponseEntity.ok().build();
    }
}

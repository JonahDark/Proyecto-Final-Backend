package com.jonatan.foodEvents.controller;

import com.jonatan.foodEvents.entities.Menu;
import com.jonatan.foodEvents.services.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

package com.jonatan.foodEvents.controller;

import com.jonatan.foodEvents.entities.Decoracion;
import com.jonatan.foodEvents.services.decoracion.DecoracionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DecoracionController {

    private final DecoracionService decoracionService;

    @GetMapping("/getAllDecoraciones")
    public ResponseEntity<List<Decoracion>> getDecoraciones() {
        return ResponseEntity.ok(decoracionService.getAllDecoraciones());
    }
}

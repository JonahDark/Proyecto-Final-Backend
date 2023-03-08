package com.jonatan.foodEvents.controller;

import com.jonatan.foodEvents.entities.Decoracion;
import com.jonatan.foodEvents.entities.Menu;
import com.jonatan.foodEvents.requests.CrearDecoracionRequest;
import com.jonatan.foodEvents.requests.CrearMenuRequest;
import com.jonatan.foodEvents.services.decoracion.DecoracionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/createDecoracion")
    public ResponseEntity<Decoracion> createDecoracion(@RequestBody CrearDecoracionRequest request) {
        return ResponseEntity.ok(decoracionService.createDecoracion(request));
    }

    @PatchMapping("/editDecoracion/{id_decoracion}")
    public ResponseEntity<Decoracion> editDecoracion(@PathVariable Long id_decoracion, @RequestBody CrearDecoracionRequest request) {
        return ResponseEntity.ok(decoracionService.editDecoracion(id_decoracion, request));
    }

    @DeleteMapping("/deleteDecoracion/{id_decoracion}")
    public ResponseEntity<Void> deleteDecoracion(@PathVariable Long id_decoracion) {
        decoracionService.deleteDecoracion(id_decoracion);
        return ResponseEntity.ok().build();
    }
}

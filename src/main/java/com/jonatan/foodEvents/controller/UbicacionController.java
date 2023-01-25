package com.jonatan.foodEvents.controller;

import com.jonatan.foodEvents.entities.Ubicacion;
import com.jonatan.foodEvents.requests.CrearUbicacionRequest;
import com.jonatan.foodEvents.services.ubicacion.UbicacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UbicacionController {

    private final UbicacionService ubicacionService;

    @GetMapping("/getAllUbicaciones")
    public ResponseEntity<List<Ubicacion>> getUbicaciones() {
        return ResponseEntity.ok(ubicacionService.getAllUbicaciones());
    }

    @GetMapping("/getUbicacion/{id_ubicacion}")
    public ResponseEntity<Ubicacion> getUbicacion(@PathVariable Long id_ubicacion) {
        return ResponseEntity.ok(ubicacionService.getUbicacionById(id_ubicacion));
    }

    @GetMapping("/getUbicacionesPorTipo/{tipo}")
    public ResponseEntity<List<Ubicacion>> getUbicacionPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(ubicacionService.getUbicacionesPorTipo(tipo));
    }

    @PostMapping("/createUbicacion")
    public ResponseEntity<Ubicacion> createUbicacion(@RequestBody CrearUbicacionRequest crearUbicacionRequest){
        return  ResponseEntity.ok(ubicacionService.createUbicacion(crearUbicacionRequest));
    }

    @PatchMapping("/editUbicacion/{id_ubicacion}")
    public ResponseEntity<Ubicacion>editUbicacion(@PathVariable Long id_ubicacion, @RequestBody CrearUbicacionRequest crearUbicacionRequest){
        return ResponseEntity.ok(ubicacionService.editUbicacion(id_ubicacion, crearUbicacionRequest));
    }

    @DeleteMapping("/deleteUbicacion/{id_ubicacion}")
    public ResponseEntity<Void>deleteUbicacion(@PathVariable Long id_ubicacion){
        ubicacionService.deleteUbicacion(id_ubicacion);
        return ResponseEntity.ok().build();
    }

}

package com.jonatan.foodEvents.controller;

import com.jonatan.foodEvents.entities.Mesa;
import com.jonatan.foodEvents.requests.CrearOEditarMesaRequest;
import com.jonatan.foodEvents.services.mesa.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MesaController {
    private final MesaService mesaService;

    @GetMapping("/getMesasDeEvento/{id_evento}")
    public ResponseEntity<List<Mesa>> getAllMesas(@PathVariable Long id_evento) {
        return ResponseEntity.ok(mesaService.getMesasPorEvento(id_evento));
    }

    @PostMapping("/addMesa")
    public ResponseEntity<Mesa> addMesa(@RequestBody CrearOEditarMesaRequest crearMesaRequest) {
        return ResponseEntity.ok(mesaService.anyadirMesa(crearMesaRequest));
    }

    @GetMapping("/getMesa/{id_mesa}")
    public ResponseEntity<Mesa> getMesa(@PathVariable("id_mesa") Long id_mesa) {
        return ResponseEntity.ok(mesaService.getMesa(id_mesa));
    }

    @DeleteMapping("/deteleMesa/{id_mesa}")
    public ResponseEntity<Void> deleteMesa(@PathVariable("id_mesa") Long id_mesa) {
        mesaService.deleteMesa(id_mesa);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/editMesa/{id_mesa}")
    public ResponseEntity<Mesa>updateMesa(@PathVariable("id_mesa") Long id_mesa, @RequestBody CrearOEditarMesaRequest editarMesaRequest){
        return ResponseEntity.ok(mesaService.editarMesa(id_mesa, editarMesaRequest));
    }
}

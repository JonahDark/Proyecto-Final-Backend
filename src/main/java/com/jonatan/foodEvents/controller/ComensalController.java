package com.jonatan.foodEvents.controller;

import com.jonatan.foodEvents.entities.Comensal;
import com.jonatan.foodEvents.requests.CrearOEditarComensalRequest;
import com.jonatan.foodEvents.services.comensal.ComensalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ComensalController {
    private final ComensalService comensalService;

    @GetMapping("/getComensalesDeMesa/{id_mesa}")
    public ResponseEntity<List<Comensal>> getComensalesDeMesa(@PathVariable Long id_mesa) {
        return ResponseEntity.ok(comensalService.getComensalesPorMesa(id_mesa));
    }

    @GetMapping("/getComensalesDeEvento/{id_evento}")
    public ResponseEntity<List<Comensal>> getComensalesDeEvento(@PathVariable Long id_evento){
        return ResponseEntity.ok((comensalService.getComensalesPorEvento(id_evento)));
    }

    @PostMapping("/addComensal")
    public ResponseEntity<Comensal> addComensal(@RequestBody CrearOEditarComensalRequest crearComensalRequest) {
        return ResponseEntity.ok(comensalService.anyadirComensal(crearComensalRequest));
    }


    @DeleteMapping("/deteleComensal/{id_comensal}")
    public ResponseEntity<Void> deleteComensal(@PathVariable("id_comensal") Long id_comensal) {
        comensalService.deleteComensal(id_comensal);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/editComensal/{id_comensal}")
    public ResponseEntity<Comensal> updateComensal(@PathVariable("id_comensal") Long id_comensal, @RequestBody CrearOEditarComensalRequest editarComensalRequest) {
        return ResponseEntity.ok(comensalService.editarComensal(id_comensal, editarComensalRequest));
    }
}

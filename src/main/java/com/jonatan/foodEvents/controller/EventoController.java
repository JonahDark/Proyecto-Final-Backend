package com.jonatan.foodEvents.controller;

import com.jonatan.foodEvents.entities.Evento;
import com.jonatan.foodEvents.requests.CrearEventoRequest;
import com.jonatan.foodEvents.requests.EditarEventoRequest;
import com.jonatan.foodEvents.services.evento.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EventoController {
    private final EventoService eventoService;

    //CREAR EVENTO
    @PostMapping("/crearEvento")
    public ResponseEntity<Evento> crearEvento(@RequestBody CrearEventoRequest crearEventoRequest) {
        return ResponseEntity.ok(eventoService.crearEvento(crearEventoRequest));
    }

    //EDITAR EVENTO
    @PatchMapping("/updateEvento/{id_evento}")
    public ResponseEntity<Evento> updateEvento(@RequestBody EditarEventoRequest editarEventoRequest, @PathVariable Long id_evento) {
        return ResponseEntity.ok(eventoService.updateEvento(id_evento, editarEventoRequest));
    }

    //OBTENER EVENTOS DE UN USUARIO
    @GetMapping("/getEventosDeUsuario/{id_usuario}")
    public ResponseEntity<List<Evento>> getEventosDeUsuario(@PathVariable Long id_usuario) {
        return ResponseEntity.ok(eventoService.getEventosDeUsuario(id_usuario));
    }

    @GetMapping("/getAllEventos")
    public ResponseEntity<List<Evento>> getAllEventos() {
        return ResponseEntity.ok(eventoService.getAllEventos());
    }

    @DeleteMapping("/deteleEvento/{id_evento}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id_evento) {
        eventoService.deleteEvento(id_evento);
        return ResponseEntity.ok().build();
    }


}

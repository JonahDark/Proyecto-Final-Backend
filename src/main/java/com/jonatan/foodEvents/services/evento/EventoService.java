package com.jonatan.foodEvents.services.evento;



import com.jonatan.foodEvents.entities.Evento;
import com.jonatan.foodEvents.requests.CrearEventoRequest;
import com.jonatan.foodEvents.requests.EditarEventoRequest;

import java.util.List;

public interface EventoService {
    Evento crearEvento(CrearEventoRequest crearEventoRequest);

    Evento updateEvento(Long id_evento, EditarEventoRequest editarEventoRequest);

    List<Evento> getEventosDeUsuario(Long id_usuario);
    List<Evento> getAllEventos();

    void deleteEvento(Long id_evento);

}

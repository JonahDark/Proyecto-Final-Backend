package com.jonatan.foodEvents.services.mesa;

import com.jonatan.foodEvents.entities.Mesa;
import com.jonatan.foodEvents.requests.CrearOEditarMesaRequest;

import java.util.List;

public interface MesaService {
    List<Mesa> getMesasPorEvento(Long id_evento);
    Mesa getMesa(Long id_mesa);
    Mesa anyadirMesa(CrearOEditarMesaRequest crearMesaRequest);
    Mesa editarMesa(Long id_mesa, CrearOEditarMesaRequest crearMesaRequest);
    void deleteMesa(Long id_mesa);
}

package com.jonatan.foodEvents.services.comensal;

import com.jonatan.foodEvents.entities.Comensal;
import com.jonatan.foodEvents.requests.CrearOEditarComensalRequest;


import java.util.List;

public interface ComensalService {
    List<Comensal> getComensalesPorMesa(Long id_mesa);
    List<Comensal> getComensalesPorEvento(Long id_evento);

    Comensal getComensal(Long id_comensal);

    Comensal anyadirComensal(CrearOEditarComensalRequest crearComensalRequest);

    Comensal editarComensal(Long id_comensal, CrearOEditarComensalRequest editarComensalRequest);

    void deleteComensal(Long id_comensal);

}

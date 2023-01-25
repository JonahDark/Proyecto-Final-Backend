package com.jonatan.foodEvents.services.ubicacion;

import com.jonatan.foodEvents.entities.Ubicacion;
import com.jonatan.foodEvents.requests.CrearUbicacionRequest;


import java.util.List;


public interface UbicacionService {
    List<Ubicacion>getAllUbicaciones();
    Ubicacion getUbicacionById(Long id);
    List<Ubicacion>getUbicacionesPorTipo(String tipo);
    Ubicacion createUbicacion(CrearUbicacionRequest crearUbicacionRequest);
    Ubicacion editUbicacion(Long id_ubicacion, CrearUbicacionRequest crearUbicacionRequest);
    void deleteUbicacion(Long id_ubicacion);


}

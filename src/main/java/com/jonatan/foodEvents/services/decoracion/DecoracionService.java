package com.jonatan.foodEvents.services.decoracion;

import com.jonatan.foodEvents.entities.Decoracion;
import com.jonatan.foodEvents.entities.Menu;
import com.jonatan.foodEvents.requests.CrearDecoracionRequest;
import com.jonatan.foodEvents.requests.CrearMenuRequest;


import java.util.List;

public interface DecoracionService {
 List<Decoracion>getAllDecoraciones();

 Decoracion createDecoracion(CrearDecoracionRequest request);
 Decoracion editDecoracion(Long id_decoracion, CrearDecoracionRequest request);
 void deleteDecoracion(Long id_decoracion);

}

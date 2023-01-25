package com.jonatan.foodEvents.services.decoracion;

import com.jonatan.foodEvents.entities.Decoracion;
import com.jonatan.foodEvents.repositories.DecoracionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*@RequiredArgsConstructor Genera un constructor con los argumentos requeridos.
 Los argumentos obligatorios son campos finales no inicializados y
  campos con restricciones como @NonNull.
  El modificador de acceso predeterminado es público*/
@RequiredArgsConstructor
public class DecoracionServiceImpl implements DecoracionService {
    private final DecoracionRepository decoracionRepository;

    @Override
    public List<Decoracion> getAllDecoraciones() {
        return decoracionRepository.findAll();
    }
}

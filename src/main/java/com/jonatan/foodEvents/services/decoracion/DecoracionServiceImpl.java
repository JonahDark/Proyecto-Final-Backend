package com.jonatan.foodEvents.services.decoracion;

import com.jonatan.foodEvents.entities.Decoracion;
import com.jonatan.foodEvents.entities.Menu;
import com.jonatan.foodEvents.repositories.DecoracionRepository;
import com.jonatan.foodEvents.requests.CrearDecoracionRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/*@RequiredArgsConstructor Genera un constructor con los argumentos requeridos.
 Los argumentos obligatorios son campos finales no inicializados y
  campos con restricciones como @NonNull.
  El modificador de acceso predeterminado es público*/
@RequiredArgsConstructor
public class DecoracionServiceImpl implements DecoracionService {
    private final DecoracionRepository decoracionRepository;

    @Override
    public Decoracion createDecoracion(CrearDecoracionRequest request) {
        Decoracion decoracion = new Decoracion();
        BeanUtils.copyProperties(request, decoracion);
        return decoracionRepository.save(decoracion);
    }

    @Override
    public Decoracion editDecoracion(Long id_decoracion, CrearDecoracionRequest request) {
        Optional<Decoracion> optionalDecoracion = decoracionRepository.findById(id_decoracion);
        if (optionalDecoracion.isPresent()) {
            Decoracion decoracion = optionalDecoracion.get();
            decoracion.setFoto(request.getFoto());
            decoracion.setPrecio(request.getPrecio());
            decoracion.setNombre(request.getNombre());
            decoracion.setTipo(request.getTipo());
            return decoracionRepository.save(decoracion);
        } else {
            throw new EntityNotFoundException("No existe ésta decpracopm con éste ID");
        }
    }

    @Override
    public void deleteDecoracion(Long id_decoracion) {

        Optional<Decoracion> optionalDecoracion = decoracionRepository.findById(id_decoracion);
        if (optionalDecoracion.isPresent()) {
            decoracionRepository.deleteById(id_decoracion);
        }else {
            throw new EntityNotFoundException("No existe ésta decoración con éste ID");
        }
    }

    @Override
    public List<Decoracion> getAllDecoraciones() {
        return decoracionRepository.findAll();
    }
}

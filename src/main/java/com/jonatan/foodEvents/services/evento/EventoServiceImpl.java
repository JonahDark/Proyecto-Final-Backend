package com.jonatan.foodEvents.services.evento;


import com.jonatan.foodEvents.entities.*;
import com.jonatan.foodEvents.repositories.*;
import com.jonatan.foodEvents.requests.CrearEventoRequest;
import com.jonatan.foodEvents.requests.EditarEventoRequest;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
/*@RequiredArgsConstructor Genera un constructor con los argumentos requeridos.
 Los argumentos obligatorios son campos finales no inicializados y
  campos con restricciones como @NonNull.
  El modificador de acceso predeterminado es público*/
@RequiredArgsConstructor
public class EventoServiceImpl implements EventoService {
    private final EventoRepository eventoRepository;
    private final UserRepository usuarioRepository;
    private final DecoracionRepository decoracionRepository;
    private final UbicacionRepository ubicacionRepository;

    private final MenuRepository menuRepository;


    @Override
    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento crearEvento(CrearEventoRequest crearEventoRequest) {
        Optional<User> optionalUsuario = usuarioRepository.findById(crearEventoRequest.getId_usuario());
        Optional<Decoracion> optionalDecoracion = decoracionRepository.findById(crearEventoRequest.getId_decoracion());
        Optional<Ubicacion> optionalUbicacion = ubicacionRepository.findById(crearEventoRequest.getId_ubicacion());
        Optional<Menu> optionalMenu = menuRepository.findById(crearEventoRequest.getId_menu());

        if (!optionalUsuario.isPresent() || !optionalDecoracion.isPresent() || !optionalMenu.isPresent() || !optionalUbicacion.isPresent()) {
            throw new EntityNotFoundException("Evento no creado");
        }

        Evento evento = new Evento();
        BeanUtils.copyProperties(crearEventoRequest, evento);
        evento.setUsuario(optionalUsuario.get());
        evento.setDecoracion(optionalDecoracion.get());
        evento.setUbicacion(optionalUbicacion.get());
        evento.setMenu((optionalMenu.get()));
        return eventoRepository.save(evento);
    }

    @Override
    public Evento updateEvento(Long id_evento, EditarEventoRequest editarEventoRequest) {

        Optional<User> optionalUsuario = usuarioRepository.findById(editarEventoRequest.getUsuario().getId());
        Optional<Decoracion> optionalDecoracion = decoracionRepository.findById(editarEventoRequest.getDecoracion().getId());
        Optional<Ubicacion> optionalUbicacion = ubicacionRepository.findById(editarEventoRequest.getUbicacion().getId());
        Optional<Menu> optionalMenu = menuRepository.findById(editarEventoRequest.getMenu().getId());

        if (!optionalUsuario.isPresent() || !optionalDecoracion.isPresent() || !optionalMenu.isPresent() || !optionalUbicacion.isPresent()) {
            throw new EntityNotFoundException("Evento no creado");
        }
        Optional<Evento> optionalEvento = eventoRepository.findById(id_evento);
        if (!optionalEvento.isPresent()) {
            throw new EntityNotFoundException("Evento no creado");
        }

        Evento evento = optionalEvento.get();
        evento.setPrecio_total(editarEventoRequest.getPrecio_total());
        evento.setPago_confirmado(editarEventoRequest.getPago_confirmado());
        evento.setFecha(editarEventoRequest.getFecha());
        evento.setTipo(editarEventoRequest.getTipo());
        evento.setNombre(editarEventoRequest.getNombre());
        evento.setHorario(editarEventoRequest.getHorario());
        evento.setUsuario(optionalUsuario.get());
        evento.setDecoracion(optionalDecoracion.get());
        evento.setUbicacion(optionalUbicacion.get());
        evento.setMenu((optionalMenu.get()));
        return eventoRepository.save(evento);
    }


    @Override
    public List<Evento> getEventosDeUsuario(Long id_usuario) {
        Optional<User> optionalUsuario = usuarioRepository.findById(id_usuario);
        List<Evento> eventos = eventoRepository.findAll();
        List<Evento> eventosDeUsuario = new ArrayList<>();
        if (optionalUsuario.isPresent()) {
            for (Evento evento : eventos) {
                if (evento.getUsuario().getId() == id_usuario) {
                    eventosDeUsuario.add(evento);
                }
            }
            return eventosDeUsuario;
        }else{
            throw new EntityNotFoundException("No existe ninguna entidad usuario con éste ID");
        }


    }

    @Override
    public void deleteEvento(Long id_evento) {
        Optional<Evento> optionalEvento = eventoRepository.findById(id_evento);
        if (!optionalEvento.isPresent()) {
            throw new EntityNotFoundException("La entidad evento no existe con éste ID");
        }
        eventoRepository.deleteById(id_evento);
    }
}

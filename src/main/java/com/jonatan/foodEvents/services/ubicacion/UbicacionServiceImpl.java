package com.jonatan.foodEvents.services.ubicacion;

import com.jonatan.foodEvents.entities.Ubicacion;
import com.jonatan.foodEvents.requests.CrearUbicacionRequest;
import com.jonatan.foodEvents.repositories.UbicacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UbicacionServiceImpl implements UbicacionService {
    private final UbicacionRepository ubicacionRepository;

    @Override
    public void deleteUbicacion(Long id_ubicacion) {
        Optional<Ubicacion> optionalUbicacion = ubicacionRepository.findById(id_ubicacion);
        if(optionalUbicacion.isPresent()){
            ubicacionRepository.deleteById(id_ubicacion);
        }else{
            throw new EntityNotFoundException("No existe ésta ubicación con éste ID");
        }
    }

    @Override
    public Ubicacion editUbicacion(Long id_ubicacion, CrearUbicacionRequest crearUbicacionRequest) {
        Optional<Ubicacion> optionalUbicacion = ubicacionRepository.findById(id_ubicacion);
        if(optionalUbicacion.isPresent()){
            Ubicacion ubicacion = optionalUbicacion.get();
            ubicacion.setAforo(crearUbicacionRequest.getAforo());
            ubicacion.setTipo(crearUbicacionRequest.getTipo());
            ubicacion.setNombre(crearUbicacionRequest.getNombre());
            ubicacion.setDescripcion(crearUbicacionRequest.getDescripcion());
            ubicacion.setPrecio(crearUbicacionRequest.getPrecio());
            ubicacion.setFoto(crearUbicacionRequest.getFoto());
            return ubicacionRepository.save(ubicacion);
        }else{
            throw new EntityNotFoundException("No existe ésta ubicación con éste ID");
        }
    }

    @Override
    public Ubicacion createUbicacion(CrearUbicacionRequest crearUbicacionRequest) {
        Ubicacion ubicacion = new Ubicacion();
        BeanUtils.copyProperties(crearUbicacionRequest, ubicacion);
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public List<Ubicacion> getAllUbicaciones() {
        return ubicacionRepository.findAll();
    }

    @Override
    public Ubicacion getUbicacionById(Long id) {
        Optional<Ubicacion> optionalUbicacion = ubicacionRepository.findById(id);
        if (optionalUbicacion.isPresent()) {
            return optionalUbicacion.get();
        }
        throw new EntityNotFoundException("No existe ninguna ubicación con este id");
    }


    @Override
    public List<Ubicacion> getUbicacionesPorTipo(String tipo) {
        List<Ubicacion> ubicaciones = ubicacionRepository.findAll();
        if(ubicaciones.isEmpty()){
            throw new EntityNotFoundException("No existe el tipo introducido");
        }
        List<Ubicacion> ubicacionesFiltradas = new ArrayList<>();
        for (Ubicacion ubicacion : ubicaciones) {
            if (ubicacion.getTipo().toString().equals(tipo)) {
                ubicacionesFiltradas.add(ubicacion);
            }
        }
        return ubicacionesFiltradas;
    }
}

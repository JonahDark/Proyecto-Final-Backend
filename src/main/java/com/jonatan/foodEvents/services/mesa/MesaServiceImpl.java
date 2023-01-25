package com.jonatan.foodEvents.services.mesa;

import com.jonatan.foodEvents.entities.Evento;
import com.jonatan.foodEvents.entities.Mesa;
import com.jonatan.foodEvents.requests.CrearOEditarMesaRequest;
import com.jonatan.foodEvents.repositories.EventoRepository;
import com.jonatan.foodEvents.repositories.MesaRepository;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MesaServiceImpl implements MesaService {
    private final MesaRepository mesaRepository;
    private final EventoRepository eventoRepository;



    @Override
    public List<Mesa> getMesasPorEvento(Long id_evento) {
        Optional<Evento> optionalEvento = eventoRepository.findById(id_evento);
        List<Mesa> mesas = mesaRepository.findAll();
        List<Mesa> mesasDeEvento = new ArrayList<>();
        if (optionalEvento.isPresent()) {
            for (Mesa mesa : mesas) {
               if(mesa.getMesa_evento().getId() == id_evento){
                   mesasDeEvento.add(mesa);
               }
            }
            return mesasDeEvento;
        }
        throw new EntityNotFoundException("EL EVENTO NO EXISTE");
    }

    @Override
    public Mesa anyadirMesa(CrearOEditarMesaRequest crearMesaRequest) {
        Optional<Evento> optionalEvento = eventoRepository.findById(crearMesaRequest.getId_evento());
        if (!optionalEvento.isPresent()) {
            throw new EntityNotFoundException("La entidad mesa no existe con éste ID");
        }
        Mesa mesa = new Mesa();
        BeanUtils.copyProperties(crearMesaRequest, mesa);
        mesa.setMesa_evento(optionalEvento.get());
        if(crearMesaRequest.getTipoMesa().toString().equals("Redonda")){
            mesa.setNum_max_comensales(3);
        }
        if(crearMesaRequest.getTipoMesa().toString().equals("Larga")){
            mesa.setNum_max_comensales(50);
        }
        if(crearMesaRequest.getTipoMesa().toString().equals("MediaLuna")){
            mesa.setNum_max_comensales(10);
        }
        return mesaRepository.save(mesa);
    }

    @Override
    public Mesa getMesa(Long id_mesa) {
        Optional<Mesa> optionalMesa = mesaRepository.findById(id_mesa);
        if(optionalMesa.isPresent()){
            return optionalMesa.get();
        }
        throw new EntityNotFoundException("La entidad mesa no existe con este ID");
    }

    @Override
    public Mesa editarMesa(Long id_mesa, CrearOEditarMesaRequest crearMesaRequest) {
        Optional<Mesa> optionalMesa = mesaRepository.findById(id_mesa);
        if(!optionalMesa.isPresent()){
            throw new EntityNotFoundException("No existe una mesa con el id indicado");
        }
        Mesa mesa = optionalMesa.get();
        mesa.setTipoMesa(crearMesaRequest.getTipoMesa());
        mesa.setNombre(crearMesaRequest.getNombre());
        return mesaRepository.save(mesa);
    }

    @Override
    public void deleteMesa(Long id_mesa) {
        Optional<Mesa> optionalMesa = mesaRepository.findById(id_mesa);
        if(!optionalMesa.isPresent()){
            throw new EntityNotFoundException("La entidad mesa no existe con éste ID");
        }
        mesaRepository.deleteById(id_mesa);
    }
}


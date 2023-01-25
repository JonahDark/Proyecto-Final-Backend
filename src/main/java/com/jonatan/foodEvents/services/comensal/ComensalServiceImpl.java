package com.jonatan.foodEvents.services.comensal;

import com.jonatan.foodEvents.entities.Comensal;
import com.jonatan.foodEvents.entities.Evento;
import com.jonatan.foodEvents.entities.Mesa;
import com.jonatan.foodEvents.requests.CrearOEditarComensalRequest;
import com.jonatan.foodEvents.repositories.ComensalRepository;
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
public class ComensalServiceImpl implements ComensalService {

    private final ComensalRepository comensalRepository;
    private final MesaRepository mesaRepository;
    private final EventoRepository eventoRepository;

    @Override
    public List<Comensal> getComensalesPorMesa(Long id_mesa) {
        Optional<Mesa> optionalMesa = mesaRepository.findById(id_mesa);
        List<Comensal> comensales = comensalRepository.findAll();
        List<Comensal> comensalesDeMesa = new ArrayList<>();
        if (optionalMesa.isPresent()) {
            for (Comensal comensal : comensales) {
                Long id_mesa_comensal = comensal.getMesa().getId();
                if (id_mesa_comensal == id_mesa) {
                    comensalesDeMesa.add(comensal);
                }
            }
            return comensalesDeMesa;
        }
        throw new EntityNotFoundException("La entidad mesa no existe con este ID");
    }


    @Override
    public List<Comensal> getComensalesPorEvento(Long id_evento) {
        Optional<Evento> optionalEvento = eventoRepository.findById(id_evento);
        List<Comensal> comensalList = comensalRepository.findAll();
        List<Comensal> comensalesDeEvento = new ArrayList<>();

        if (optionalEvento.isPresent()) {
            Evento evento = optionalEvento.get();
            for (Mesa mesa : evento.getMesas()) {
                for (Comensal comensal : mesa.getComensales()) {
                    comensalesDeEvento.add(comensal);
                }
            }
            return comensalesDeEvento;
        } else {
            throw new EntityNotFoundException("La entidad evento no existe con este ID");
        }
    }

    @Override
    public Comensal getComensal(Long id_comensal) {
        Optional<Comensal> optionalComensal = comensalRepository.findById(id_comensal);
        if (optionalComensal.isPresent()) {
            return optionalComensal.get();
        }
        throw new EntityNotFoundException("La entidad comensal no existe con este ID");
    }

    @Override
    public Comensal anyadirComensal(CrearOEditarComensalRequest crearComensalRequest) {
        System.out.println(crearComensalRequest);
        Optional<Mesa> optionalMesa = mesaRepository.findById(crearComensalRequest.getId_mesa());
        if (!optionalMesa.isPresent()) {
            throw new EntityNotFoundException("La entidad mesa no existe con este ID");
        }
        Comensal comensal = new Comensal();
        BeanUtils.copyProperties(crearComensalRequest, comensal);
        comensal.setMesa(optionalMesa.get());
        return comensalRepository.save(comensal);
    }

    @Override
    public Comensal editarComensal(Long id_comensal, CrearOEditarComensalRequest editarComensalRequest) {
        Optional<Comensal> optionalComensal = comensalRepository.findById(id_comensal);
        if (!optionalComensal.isPresent()) {
            throw new EntityNotFoundException("La entidad comensal no existe con este ID");
        }
        Comensal comensal = optionalComensal.get();
        comensal.setNombre(editarComensalRequest.getNombre());
        comensal.setApellidos(editarComensalRequest.getApellidos());
        comensal.setAlergeno(editarComensalRequest.getAlergeno());
        comensal.setInfantil(editarComensalRequest.getInfantil());
        return comensalRepository.save(comensal);
    }

    @Override
    public void deleteComensal(Long id_comensal) {
        Optional<Comensal> optionalComensal = comensalRepository.findById(id_comensal);
        if (!optionalComensal.isPresent()) {
            throw new EntityNotFoundException("La entidad comensal no existe con este ID");
        }
        comensalRepository.deleteById(id_comensal);
    }
}

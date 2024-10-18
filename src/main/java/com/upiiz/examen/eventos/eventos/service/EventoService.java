package com.upiiz.examen.eventos.eventos.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upiiz.examen.eventos.eventos.model.Evento;
import com.upiiz.examen.eventos.eventos.repository.EventoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // Obtener todos los eventos
    public List<Evento> obtenerTodosLosEventos() {
        return eventoRepository.findAll()   ;
    }

    // Obtener un evento por ID
    public Optional<Evento> obtenerEventoPorId(String id) {
        return eventoRepository.findById(id);
    }

    // Agregar un nuevo evento
    public Evento agregarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    // Actualizar un evento existente
    public Evento actualizarEvento(String id, Evento evento) {
        evento.setId(id); // Asegurar que se actualiza el evento correcto
        return eventoRepository.save(evento);
    }

    // Eliminar un evento por ID
    public void eliminarEvento(String id) {
        eventoRepository.deleteById(id);
    }
}

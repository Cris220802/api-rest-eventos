package com.upiiz.examen.eventos.eventos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.upiiz.examen.eventos.eventos.service.EventoService;
import com.upiiz.examen.eventos.eventos.validation.ValidMongoID;

import jakarta.validation.Valid;

import com.upiiz.examen.eventos.eventos.model.Evento;

@RestController
@RequestMapping("/api/v1/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> listarEventos() {
        return eventoService.obtenerTodosLosEventos();
    }

    @GetMapping("/{id}")
    public Optional<Evento> obtenerEvento(@PathVariable @ValidMongoID String id) {
        return eventoService.obtenerEventoPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> agregarEvento(@Valid @RequestBody Evento evento, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(validar(result), HttpStatus.BAD_REQUEST);
        }
        Evento nuevoEvento = eventoService.agregarEvento(evento);
        return new ResponseEntity<>(nuevoEvento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEvento(@Valid @PathVariable @ValidMongoID String id, @RequestBody Evento evento, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(validar(result), HttpStatus.BAD_REQUEST);
        }
        Evento eventoEditado = eventoService.actualizarEvento(id, evento);
        return new ResponseEntity<>(eventoEditado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarEvento(@PathVariable String id) {
        eventoService.eliminarEvento(id);
    }

     private Map<String, String> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });
        return errores;
    }
}

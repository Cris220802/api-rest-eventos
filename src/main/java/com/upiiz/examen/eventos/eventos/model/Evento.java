package com.upiiz.examen.eventos.eventos.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Document(collection = "eventos")
public class Evento {

    @Id
    private String id;  // MongoDB usa cadenas de texto para los IDs

    // Validar Titulo
    @NotEmpty(message = "El título es obligatorio")
    private String titulo;

    @NotNull(message = "La fecha no debe estar vacia")
    private LocalDateTime fechaHora;

    @NotEmpty(message = "El lugar del Evento es obligatorio")
    private String lugar;

    // Constructor por defecto
    public Evento() {}

    // Constructor con parámetros
    public Evento(String titulo, LocalDateTime fechaHora, String lugar) {
        this.titulo = titulo;
        this.fechaHora = fechaHora;
        this.lugar = lugar;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}

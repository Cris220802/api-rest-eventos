package com.upiiz.examen.eventos.eventos.repository;
import com.upiiz.examen.eventos.eventos.model.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventoRepository extends MongoRepository<Evento, String>{

}

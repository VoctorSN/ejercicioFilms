package edu.badpals.ejercicio413.model.repository;

import edu.badpals.ejercicio413.model.entity.Usuario;
import edu.badpals.ejercicio413.model.entity.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VoteRepository  extends CrudRepository<Vote, Long> {
    Optional<Vote> findByUsuario(Usuario user);

}
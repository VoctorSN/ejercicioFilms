package edu.badpals.ejercicio413.model.repository;

import edu.badpals.ejercicio413.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Objects;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
package edu.badpals.ejercicio413.model.repository;

import edu.badpals.ejercicio413.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Objects;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    default Optional<Usuario> findByEmail(String email) {
        Iterable<Usuario> users = this.findAll();
        for (Usuario user : users) {
            if (Objects.equals(user.getEmail(), email)) {
                return Optional.of(user);

            }
        }
        return Optional.empty();
    }
}
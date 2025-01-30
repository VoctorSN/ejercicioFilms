package edu.badpals.ejercicio413.model.service;

import edu.badpals.ejercicio413.model.entity.Usuario;
import edu.badpals.ejercicio413.model.repository.PeliculaRepository;
import edu.badpals.ejercicio413.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> findByEmail(String email) {
        Iterable<Usuario> users = usuarioRepository.findAll();
        for (Usuario user : users) {
            if (Objects.equals(user.getEmail(), email)) {
                return Optional.of(user);

            }
        }
        return Optional.empty();
    }

    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
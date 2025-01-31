package edu.badpals.ejercicio413.model.service;

import edu.badpals.ejercicio413.model.entity.Usuario;
import edu.badpals.ejercicio413.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> findByEmail(String email) {
        return StreamSupport.stream(usuarioRepository.findAll().spliterator(), true)
                .filter(u -> Objects.equals(u.getEmail(), email))
                .findFirst();
    }

    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
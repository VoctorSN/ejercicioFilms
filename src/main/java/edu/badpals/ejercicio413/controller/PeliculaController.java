package edu.badpals.ejercicio413.controller;

import edu.badpals.ejercicio413.model.entity.Pelicula;
import edu.badpals.ejercicio413.model.entity.Usuario;
import edu.badpals.ejercicio413.model.repository.PeliculaRepository;
import edu.badpals.ejercicio413.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PeliculaController {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/peliculas")
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaRepository.findAll());
        return "peliculas";
    }

    @PostMapping("/peliculas/votar")
    public String votarPelicula(@RequestParam Long idPelicula, @RequestParam String email, Model model) {
        Pelicula pelicula = peliculaRepository.findById(idPelicula).orElse(null);
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(new Usuario(email));
        if (pelicula != null) {
            usuario.setPelicula(pelicula);
            usuarioRepository.save(usuario);
        }
        return "redirect:/peliculas";
    }

}
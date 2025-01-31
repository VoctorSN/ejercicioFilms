package edu.badpals.ejercicio413.controller;

import edu.badpals.ejercicio413.model.entity.Pelicula;
import edu.badpals.ejercicio413.model.entity.Usuario;
import edu.badpals.ejercicio413.model.repository.PeliculaRepository;
import edu.badpals.ejercicio413.model.repository.UsuarioRepository;
import edu.badpals.ejercicio413.model.service.PeliculaService;
import edu.badpals.ejercicio413.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/peliculas")
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.getPeliculas());
        return "peliculas";
    }

    @PostMapping("/peliculas/votar")
    public String votarPelicula(@RequestParam Long idPelicula, @RequestParam String email, Model model) {
        Optional<Pelicula> pelicula = peliculaService.get(idPelicula);
        Usuario usuario = usuarioService.findByEmail(email).orElse(new Usuario(email));
        if (pelicula.isPresent()) {
            usuario.setPelicula(pelicula.get());
            usuarioService.guardar(usuario);
        }
        return "redirect:/peliculas";
    }

}
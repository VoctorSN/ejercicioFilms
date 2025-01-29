package edu.badpals.ejercicio413.controller;

import edu.badpals.ejercicio413.model.entity.Pelicula;
import edu.badpals.ejercicio413.model.entity.Usuario;
import edu.badpals.ejercicio413.model.entity.Vote;
import edu.badpals.ejercicio413.model.repository.PeliculaRepository;
import edu.badpals.ejercicio413.model.repository.UsuarioRepository;
import edu.badpals.ejercicio413.model.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeliculaController {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VoteRepository voteRepository;

    @GetMapping("/peliculas")
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaRepository.findAll());
        return "peliculas";
    }

    @PostMapping("/peliculas/votar/{idPelicula}/{email}")
    public String votarPelicula(@PathVariable Long idPelicula, @PathVariable String email) {
        Pelicula pelicula = peliculaRepository.findById(idPelicula).orElse(null);
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(new Usuario(email));
        if (pelicula != null) {
            Vote vote = voteRepository.findByUsuario(usuario).orElse(new Vote());
            vote.setUsuario(usuario);
            vote.setPelicula(pelicula);
            voteRepository.save(vote);
        }
        return "redirect:/peliculas";
    }

}
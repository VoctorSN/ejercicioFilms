package edu.badpals.ejercicio413.model.service;

import edu.badpals.ejercicio413.model.entity.Pelicula;
import edu.badpals.ejercicio413.model.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeliculaService {
    private PeliculaRepository peliculaRepository;


    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
        peliculaRepository.save(new Pelicula("Avatar", "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-Qzx9P3SPQhxUCGOuXLMbiIB7GleKqi.png"));
        peliculaRepository.save(new Pelicula("The Shawshank Redemption", "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-Qzx9P3SPQhxUCGOuXLMbiIB7GleKqi.png"));
        peliculaRepository.save(new Pelicula("Pulp Fiction", "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-Qzx9P3SPQhxUCGOuXLMbiIB7GleKqi.png"));
        peliculaRepository.save(new Pelicula("Pulp Fiction", "https://i.blogs.es/8ef1df/joker-joaquin-phoenix/1366_2000.jpg"));
    }

    public Object getPeliculas() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> get(Long idPelicula) {
        return peliculaRepository.findById(idPelicula);
    }
}
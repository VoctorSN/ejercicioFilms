package edu.badpals.ejercicio413;

import edu.badpals.ejercicio413.model.entity.Pelicula;
import edu.badpals.ejercicio413.model.repository.PeliculaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

  private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataJpaApplication.class);
  }

  @Bean
  public CommandLineRunner demoPelicula(PeliculaRepository peliculas) {
    return (args) -> {
      peliculas.save(new Pelicula("Avatar", "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-Qzx9P3SPQhxUCGOuXLMbiIB7GleKqi.png"));
      peliculas.save(new Pelicula("The Shawshank Redemption", "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-Qzx9P3SPQhxUCGOuXLMbiIB7GleKqi.png"));
      peliculas.save(new Pelicula("Pulp Fiction", "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-Qzx9P3SPQhxUCGOuXLMbiIB7GleKqi.png"));
      peliculas.save(new Pelicula("Pulp Fiction", "https://i.blogs.es/8ef1df/joker-joaquin-phoenix/1366_2000.jpg"));


    };
  }
}
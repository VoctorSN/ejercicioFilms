package edu.badpals.ejercicio413.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String imagenUrl;

    @OneToMany(mappedBy = "pelicula")
    private List<Usuario> usuarios;

    public Pelicula(String titulo, String imagenUrl) {
        this.titulo = titulo;
        this.imagenUrl = imagenUrl;
    }

    public void addVote(Usuario vote){
        usuarios.add(vote);
    }

    public int getNumberVotes(){
        return usuarios.size();
    }
}
package edu.badpals.ejercicio413.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    @ManyToOne()
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    public Usuario(String email){
        this.email = email;
    }
}
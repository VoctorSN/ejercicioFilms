package edu.badpals.ejercicio413.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
    private String email;

    @OneToOne(mappedBy = "usuario")
    private Vote vote;

    public Usuario(String email){
        this.email = email;
    }
}
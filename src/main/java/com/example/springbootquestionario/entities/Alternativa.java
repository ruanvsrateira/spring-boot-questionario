package com.example.springbootquestionario.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Alternativa {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private Boolean correta;
    @ManyToOne
    @JoinColumn(name="questao_id")
    private Questao questao;
}

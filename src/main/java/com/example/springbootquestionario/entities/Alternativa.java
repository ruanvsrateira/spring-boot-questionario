package com.example.springbootquestionario.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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

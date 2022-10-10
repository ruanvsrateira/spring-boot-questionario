package com.example.springbootquestionario.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class QuestaoVO {
    private String titulo;
    private Integer pontos;
    private String alternativa1;
    private Boolean alternativa1Correta;
    private String alternativa2;
    private Boolean alternativa2Correta;
    private String alternativa3;
    private Boolean alternativa3Correta;
    private String alternativa4;
    private Boolean alternativa4Correta;
}

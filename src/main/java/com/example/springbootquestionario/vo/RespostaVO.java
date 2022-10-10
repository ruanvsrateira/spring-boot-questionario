package com.example.springbootquestionario.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class RespostaVO {
    private Integer usuarioId;
    private Boolean alternativa1Escolhida;
    private Boolean alternativa2Escolhida;
    private Boolean alternativa3Escolhida;
    private Boolean alternativa4Escolhida;
}

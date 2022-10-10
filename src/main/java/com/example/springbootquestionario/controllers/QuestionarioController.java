package com.example.springbootquestionario.controllers;

import com.example.springbootquestionario.entities.Questao;
import com.example.springbootquestionario.entities.Usuario;
import com.example.springbootquestionario.services.QuestaoService;
import com.example.springbootquestionario.services.UsuarioService;
import com.example.springbootquestionario.vo.RespostaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuestionarioController {

    public Integer numeroQuestaoGlobal = 0;
    @Autowired
    QuestaoService questaoService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("questionario/{numeroQuestao}")
    public String listarQuestões(
        @RequestParam("usuarioId") Integer usuarioId,
        @PathVariable("numeroQuestao") Integer numeroQuestao,
        Model model, RespostaVO respostaVO
    ) {
        if(numeroQuestao == 0) {
            numeroQuestaoGlobal = 0;
        }

        List<Questao> questoes = questaoService.listarQuestoes();
        if(numeroQuestao+1 > questoes.size()) {
            return "parabens";
        }

        model.addAttribute("questao", questoes.get(numeroQuestao));
        model.addAttribute("resposta", respostaVO);
        model.addAttribute("questaoId", questoes.get(numeroQuestao).getId());
        model.addAttribute("usuarioId", usuarioId);

        return "questionario";
    }
    @PostMapping("resposta-questao/{questaoId}")
    public String responderQuestionario(
        @PathVariable("questaoId") Integer questaoId,
        RespostaVO respostaVO
    ) {

        Questao questaoCadastrada = questaoService.findQuestaoById(questaoId).get();

        if(
            questaoCadastrada.getAlternativas().get(0).getCorreta().equals(respostaVO.getAlternativa1Escolhida()) &
            questaoCadastrada.getAlternativas().get(1).getCorreta().equals(respostaVO.getAlternativa2Escolhida()) &
            questaoCadastrada.getAlternativas().get(2).getCorreta().equals(respostaVO.getAlternativa3Escolhida()) &
            questaoCadastrada.getAlternativas().get(3).getCorreta().equals(respostaVO.getAlternativa4Escolhida())
        ) {
            Usuario usuario = usuarioService.findUsuarioById(respostaVO.getUsuarioId()).get();

            usuario.setPontos(usuario.getPontos() + questaoCadastrada.getPontos());

            usuarioService.criarNovoUsuario(usuario);

            numeroQuestaoGlobal++;

            return "redirect:/questionario/" + numeroQuestaoGlobal + "?usuarioId=" + respostaVO.getUsuarioId();
        } else {
            return "redirect:/placar";
        }
    }
}

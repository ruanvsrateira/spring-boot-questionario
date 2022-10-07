package com.example.springbootquestionario.controllers;

import com.example.springbootquestionario.entities.Usuario;
import com.example.springbootquestionario.repositories.UsuarioRepository;
import com.example.springbootquestionario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/cadastrar-usuario")
    public String cadastrarusuario(Usuario usuario) {
        return "cad_usuario";
    }

    @PostMapping("/cadastrar-usuario")
    public RedirectView  salvarUsuario(Usuario usuario, RedirectAttributes attributes) {
        List<Usuario> exist = service.findUsuarioByEmail(usuario.getEmail());

        if(exist.size() > 0) {
            attributes.addAttribute("usuarioId", exist.get(0).getId());
        } else {
            service.criarNovoUsuario(usuario);
            attributes.addAttribute("usuarioId", usuario.getId());
        }

        return new RedirectView("questionario");
    }
}

package com.example.springbootquestionario.services;

import com.example.springbootquestionario.repositories.UsuarioRepository;
import com.example.springbootquestionario.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    @Transactional
    public Usuario criarNovoUsuario(Usuario usuario) {
        return repo.save(usuario);
    }

    @Transactional
    public Usuario deletarUsuario(Usuario usuario) {
        repo.delete(usuario);
        return usuario;
    }

    public Iterable<Usuario> listarUsuarios() {
        return repo.findAll();
    }

    public Optional<Usuario> findUsuarioById(Integer id) {
        return repo.findById(id);
    }

    public List<Usuario> findUsuarioByEmail(String email) {
        return repo.findUsuarioByEmail(email);
    }
}

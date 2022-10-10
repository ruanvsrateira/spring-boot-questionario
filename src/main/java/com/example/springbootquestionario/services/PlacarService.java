package com.example.springbootquestionario.services;

import com.example.springbootquestionario.entities.Usuario;
import com.example.springbootquestionario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlacarService {

    @Autowired
    UsuarioRepository repo;

    public List<Usuario> listarPlacar() {
        return repo.findUsuarioOrderByPontosAsc();
    }

}

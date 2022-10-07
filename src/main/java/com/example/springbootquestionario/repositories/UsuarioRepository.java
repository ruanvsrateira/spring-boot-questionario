package com.example.springbootquestionario.repositories;

import com.example.springbootquestionario.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    List<Usuario> findUsuarioByEmail(String email);
}

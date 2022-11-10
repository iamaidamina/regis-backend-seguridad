package com.example.regisbackendseguridad.Repositories;

import org.springframework.data.mongodb.repository.Query;
import com.example.regisbackendseguridad.Models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryUsuario extends MongoRepository<Usuario,String> {
    @Query("{'correo': ?0}")
    public Usuario getUserByEmail(String correo);
}

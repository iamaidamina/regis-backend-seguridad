package com.example.regisbackendseguridad.Repositories;
import com.example.regisbackendseguridad.Models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryUsuario extends MongoRepository<Usuario,String> {

}

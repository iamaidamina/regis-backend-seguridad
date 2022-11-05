package com.example.regisbackendseguridad.Repositories;
import com.example.regisbackendseguridad.Models.Permiso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  RepositoryPermiso extends MongoRepository<Permiso,String> {
    
}

package com.example.regisbackendseguridad.Repositories;
import org.springframework.data.mongodb.repository.Query;
import com.example.regisbackendseguridad.Models.Permiso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  RepositoryPermiso extends MongoRepository<Permiso,String> {
    @Query("{'url':?0,'metodo':?1}")
    Permiso getPermiso(String url, String metodo);
}

package com.example.regisbackendseguridad.Repositories;
import org.springframework.data.mongodb.repository.Query;
import com.example.regisbackendseguridad.Models.PermisosRol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  RepositoryPermisosRol extends MongoRepository<PermisosRol,String> {
    @Query("{'rol.$id': ObjectId(?0),'permiso.$id': ObjectId(?1)}")
    PermisosRol getPermisoRol(String id_rol,String id_permiso);
}

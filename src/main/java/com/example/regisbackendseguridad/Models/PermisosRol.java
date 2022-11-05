package com.example.regisbackendseguridad.Models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class PermisosRol {
    @Id
    private String id;
    private String id_rol;
    private String id_permiso;

    public String getId(){
        return id;
    }

    public String getId_rol(){
        return id_rol;
    }

    public void setId_rol(String id_rol){
        this.id_rol = id_rol;
    }

    public String getId_permiso(){
        return id_permiso;
    }

    public void setId_permiso(String id_permiso){
        this.id_permiso = id_permiso;
    }
    
}

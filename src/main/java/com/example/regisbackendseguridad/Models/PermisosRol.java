package com.example.regisbackendseguridad.Models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class PermisosRol {
    @Id
    private String id;
    @DBRef
    private Rol rol;
    @DBRef
    private Permiso permiso;

    public PermisosRol() {
    }

    public String getId(){
        return id;
    }

    public Rol getRol() {
        return rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    
}

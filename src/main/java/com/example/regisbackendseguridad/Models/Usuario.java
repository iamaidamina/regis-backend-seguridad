package com.example.regisbackendseguridad.Models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Usuario {
    @Id
    private String id;
    private String seudonimo;
    private String correo;
    private String contrasena;
}

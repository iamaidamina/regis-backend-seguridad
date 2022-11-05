package com.example.regisbackendseguridad.Models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Permiso {
    @Id
    private String id;
    private String url;
    private String metodo;

    public String getId(){
        return id;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getMetodo(){
        return metodo;
    }

    public void setMetodo(String metodo){
        this.metodo = metodo;
    }
    
}

package modelo.entidades;
// Generated 30-may-2020 23:19:19 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Anunciante generated by hbm2java
 */
public class Anunciante  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String direccion;
     private String email;
     private Set anuncios = new HashSet(0);

    public Anunciante() {
    }

	
    public Anunciante(String nombre, String direccion, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
    }
    public Anunciante(String nombre, String direccion, String email, Set anuncios) {
       this.nombre = nombre;
       this.direccion = direccion;
       this.email = email;
       this.anuncios = anuncios;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getAnuncios() {
        return this.anuncios;
    }
    
    public void setAnuncios(Set anuncios) {
        this.anuncios = anuncios;
    }




}



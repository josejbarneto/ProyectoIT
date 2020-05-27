package modelo.entidades;
// Generated 27-may-2020 21:22:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer id;
     private String usuario;
     private int rol;
     private String nombre;
     private String email;
     private String contrasenya;
     private Set configuracions = new HashSet(0);
     private Set entradas = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String usuario, int rol, String nombre, String email, String contrasenya) {
        this.usuario = usuario;
        this.rol = rol;
        this.nombre = nombre;
        this.email = email;
        this.contrasenya = contrasenya;
    }
    public Usuario(String usuario, int rol, String nombre, String email, String contrasenya, Set configuracions, Set entradas) {
       this.usuario = usuario;
       this.rol = rol;
       this.nombre = nombre;
       this.email = email;
       this.contrasenya = contrasenya;
       this.configuracions = configuracions;
       this.entradas = entradas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public int getRol() {
        return this.rol;
    }
    
    public void setRol(int rol) {
        this.rol = rol;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContrasenya() {
        return this.contrasenya;
    }
    
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    public Set getConfiguracions() {
        return this.configuracions;
    }
    
    public void setConfiguracions(Set configuracions) {
        this.configuracions = configuracions;
    }
    public Set getEntradas() {
        return this.entradas;
    }
    
    public void setEntradas(Set entradas) {
        this.entradas = entradas;
    }




}



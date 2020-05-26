package modelo.entidades;
// Generated 24-may-2020 23:42:29 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer id;
     private Evento evento;
     private int idConfiguracion;
     private String usuario;
     private String rol;
     private String nombre;
     private String email;
     private Set configuracionsForIdUsuario = new HashSet(0);
     private Configuracion configuracionByIdConfiguracion;
     private Set entradas = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(Evento evento, int idConfiguracion, String usuario, String rol, String nombre, String email) {
        this.evento = evento;
        this.idConfiguracion = idConfiguracion;
        this.usuario = usuario;
        this.rol = rol;
        this.nombre = nombre;
        this.email = email;
    }
    public Usuario(Evento evento, int idConfiguracion, String usuario, String rol, String nombre, String email, Set configuracionsForIdUsuario, Configuracion configuracionByIdConfiguracion, Set entradas) {
       this.evento = evento;
       this.idConfiguracion = idConfiguracion;
       this.usuario = usuario;
       this.rol = rol;
       this.nombre = nombre;
       this.email = email;
       this.configuracionsForIdUsuario = configuracionsForIdUsuario;
       this.configuracionByIdConfiguracion = configuracionByIdConfiguracion;
       this.entradas = entradas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public int getIdConfiguracion() {
        return this.idConfiguracion;
    }
    
    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
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
    public Set getConfiguracionsForIdUsuario() {
        return this.configuracionsForIdUsuario;
    }
    
    public void setConfiguracionsForIdUsuario(Set configuracionsForIdUsuario) {
        this.configuracionsForIdUsuario = configuracionsForIdUsuario;
    }
    public Configuracion getConfiguracionByIdConfiguracion() {
        return this.configuracionByIdConfiguracion;
    }
    
    public void setConfiguracionByIdConfiguracion(Configuracion configuracionByIdConfiguracion) {
        this.configuracionByIdConfiguracion = configuracionByIdConfiguracion;
    }
    public Set getEntradas() {
        return this.entradas;
    }
    
    public void setEntradas(Set entradas) {
        this.entradas = entradas;
    }




}


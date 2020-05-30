/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anunciante;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.anuncianteDAO;
import modelo.entidades.Anunciante;

/**
 *
 * @author Carlos
 */
public class accionCrearAnunciante extends ActionSupport {
    
    private String nombre;
    private String direccion;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public accionCrearAnunciante() {
    }
    
    public String execute() throws Exception {
        anuncianteDAO anuncianteDAO = new anuncianteDAO();
        Anunciante anunciante = new Anunciante(nombre, direccion, email);
        anuncianteDAO.crear(anunciante);
        return SUCCESS;
    }
    
}

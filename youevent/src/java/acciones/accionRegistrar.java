/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.configuracionDAO;
import modelo.dao.usuarioDAO;
import modelo.entidades.Configuracion;
import modelo.entidades.Usuario;

/**
 *
 * @author Carlos
 */
public class accionRegistrar extends ActionSupport {

    private String nombre;
    private String usuario;
    private String password;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public accionRegistrar() {
    }

    public String execute() throws Exception {
        usuarioDAO usuarioDAO = new usuarioDAO();
        configuracionDAO configuracionDAO = new configuracionDAO();
        Usuario us = new Usuario(usuario, 0, nombre, email, password);

        Configuracion conf = new Configuracion();
       

        if (usuarioDAO.existeUsuario(us.getUsuario())) {
            return ERROR;
        } else {
            us.setId(usuarioDAO.insertUsuario(us));
            conf.setUsuario(us);
            configuracionDAO.insertConfiguracion(conf);
            
            return SUCCESS;
        }
    }

}

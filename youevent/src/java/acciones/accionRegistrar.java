/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.usuarioDAO;
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
        Usuario usuario = new Usuario();

        if (usuarioDAO.existeUsuario(usuario.getUsuario())) {
            return ERROR;
        } else {
            usuarioDAO.insertUsuario(usuario);
            return SUCCESS;
        }
    }

}

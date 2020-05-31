/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.usuario;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.dao.anuncioDAO;
import modelo.dao.usuarioDAO;
import modelo.entidades.Usuario;

/**
 *
 * @author Carlos
 */
public class redirigirAListarUsuario extends ActionSupport {
    
    private List<Usuario> listaUsuarios;

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public redirigirAListarUsuario() {
    }
    
    public String execute() throws Exception {
        listaUsuarios = new usuarioDAO().getAll();
        return SUCCESS;
    }
    
}

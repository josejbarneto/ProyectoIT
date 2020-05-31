/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.usuario;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.dao.eventoCategoriaDAO;
import modelo.dao.eventoDAO;
import modelo.dao.usuarioDAO;
import modelo.entidades.Categoria;
import modelo.entidades.Usuario;

/**
 *
 * @author Carlos
 */
public class redirigirAMostrarUsuario extends ActionSupport {
    
    private Integer idUsuario;
    private Usuario usuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public redirigirAMostrarUsuario() {
    }
    
    public String execute() throws Exception {
        usuario = new usuarioDAO().get(idUsuario); 
        return SUCCESS;
    }
    
}

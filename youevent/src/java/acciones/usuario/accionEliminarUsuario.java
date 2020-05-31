/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.usuario;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.usuarioDAO;

/**
 *
 * @author Carlos
 */
public class accionEliminarUsuario extends ActionSupport {
    
    private Integer idUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }



    
    public String execute() throws Exception {
        new usuarioDAO().eliminar(idUsuario);
        return SUCCESS;
    }
    
}

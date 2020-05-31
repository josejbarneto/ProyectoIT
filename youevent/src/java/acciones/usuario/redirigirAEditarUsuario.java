/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.usuario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import modelo.dao.usuarioDAO;
import modelo.entidades.Usuario;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class redirigirAEditarUsuario extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    private Usuario usuario;
    private int idUsuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }



    
    public String execute() throws Exception {
        usuario = new usuarioDAO().get(idUsuario); 
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}

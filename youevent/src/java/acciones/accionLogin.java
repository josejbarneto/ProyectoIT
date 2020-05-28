/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import modelo.dao.claveTemporalDAO;
import modelo.dao.usuarioDAO;
import modelo.entidades.Usuario;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class accionLogin extends ActionSupport implements SessionAware {

    private String usuario;
    private String password;
    private Map<String, Object> session;

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
    
    public accionLogin() {
    }

    public String execute() throws Exception {
        usuarioDAO usuarioDAO = new usuarioDAO();
        Usuario usuario = usuarioDAO.comprobarLogin(this.usuario, this.password);
        if (usuario != null) {
            return SUCCESS;
        } else {
            claveTemporalDAO ctDAO = new claveTemporalDAO();
            Usuario usuario2 = ctDAO.compruebaClaveTemporal(this.usuario, this.password);
            
            if(usuario2 != null){
                return SUCCESS;
            }
            
            return ERROR;
        }
    }

    public String inicio() {
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    /**
     *
     */
    public void validate() {
        if (this.usuario.equals("")) {
            addFieldError("usuario", "Error 1");
        }

        //if (!Pattern.matches("[\\\\w&&[^\\\\d]]+", this.usuario)) {
        //    addFieldError("usuario", "Error 2");
        //}

        if (this.password.equals("")) {
            addFieldError("password", "Error 3");
        }
    }
}

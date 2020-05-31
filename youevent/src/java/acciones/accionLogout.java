/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author eugen
 */
public class accionLogout extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
    
    public accionLogout() {
    }
    
    public String execute() throws Exception {
        if (session.containsKey("usuario")) {
            session.remove("usuario");
        }
        session.clear();
        return SUCCESS;
    }
    
}

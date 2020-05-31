/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.ofertas;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.dao.eventoDAO;
import modelo.entidades.Evento;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Fran
 */
public class redirigirACrearOferta extends ActionSupport implements SessionAware {
    
    private Map<String, Object> session;
    private Evento evento;
    private int idEvento;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    
    public redirigirACrearOferta() {
    }
    

    public String execute() throws Exception {
        eventoDAO eventoDAO = new eventoDAO();
        evento = eventoDAO.get(idEvento);
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
}

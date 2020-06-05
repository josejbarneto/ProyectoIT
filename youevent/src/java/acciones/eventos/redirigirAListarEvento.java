/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.eventos;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.dao.anuncioDAO;
import modelo.dao.eventoDAO;
import modelo.entidades.Evento;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class redirigirAListarEvento extends ActionSupport implements SessionAware{
    
    private List<Evento> listaEventos;
    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public List<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }
    
    public redirigirAListarEvento() {
    }
    
    public String execute() throws Exception {
        eventoDAO eventoDAO = new eventoDAO();
        
        session.put("listaAnuncios", new anuncioDAO().getAll());
        listaEventos = eventoDAO.getAll();
        return SUCCESS;
    }
    
}

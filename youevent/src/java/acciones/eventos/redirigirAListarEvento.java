/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.eventos;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.dao.eventoDAO;
import modelo.entidades.Evento;

/**
 *
 * @author Carlos
 */
public class redirigirAListarEvento extends ActionSupport {
    
    private List<Evento> listaEventos;

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
        listaEventos = eventoDAO.getAll();
        return SUCCESS;
    }
    
}

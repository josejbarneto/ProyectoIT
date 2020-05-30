/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.eventos;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.dao.eventoCategoriaDAO;
import modelo.dao.eventoDAO;
import modelo.entidades.Categoria;
import modelo.entidades.Evento;

/**
 *
 * @author Carlos
 */
public class redirigirAMostrarEvento extends ActionSupport {
    
    private Integer idEvento;
    private Evento evento;
    private List<Categoria> listaCategorias;

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public redirigirAMostrarEvento() {
    }
    
    public String execute() throws Exception {
        eventoDAO eventoDAO = new eventoDAO();
        evento = eventoDAO.get(idEvento); 
        eventoCategoriaDAO ecDAO = new eventoCategoriaDAO();
        listaCategorias = ecDAO.getCategorias(evento);
        System.out.println(listaCategorias);
        return SUCCESS;
    }
    
}

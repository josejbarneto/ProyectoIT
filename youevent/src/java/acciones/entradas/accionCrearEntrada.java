/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.entradas;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import modelo.dao.categoriaDAO;
import modelo.dao.entradaDAO;
import modelo.dao.eventoCategoriaDAO;
import modelo.dao.eventoDAO;
import modelo.entidades.Categoria;
import modelo.entidades.Entrada;
import modelo.entidades.Evento;
import modelo.entidades.EventoCategoria;
import modelo.entidades.EventoCategoriaId;
import modelo.entidades.Usuario;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Fran
 */
public class accionCrearEntrada extends ActionSupport implements SessionAware {

    private int numEntradas;
    private Map<String, Object> session;
    private int idEvento;

    public int getNumEntradas() {
        return numEntradas;
    }

    public void setNumEntradas(int numEntradas) {
        this.numEntradas = numEntradas;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String execute() throws Exception {
        Usuario usuario = (Usuario) session.get("usuario");
        entradaDAO entradaDAO = new entradaDAO();        
        eventoDAO eventoDAO = new eventoDAO();
        Evento evento = eventoDAO.get(idEvento);
        while (numEntradas > 0) {
            Entrada entrada = new Entrada(evento, usuario);
            entradaDAO.crear(entrada);
            numEntradas--;
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void validate() {

    }

}

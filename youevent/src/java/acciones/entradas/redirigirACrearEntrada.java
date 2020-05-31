/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.entradas;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import modelo.dao.entradaDAO;
import modelo.dao.eventoDAO;
import modelo.entidades.Evento;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Fran
 */
public class redirigirACrearEntrada extends ActionSupport implements SessionAware {

    private float precioTotal;
    private int numEntradas;
    private Map<String, Object> session;
    private int idEvento;
    private Evento evento;

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public String execute() throws Exception {
        entradaDAO entradaDAO = new entradaDAO();
        eventoDAO eventoDAO = new eventoDAO();
        evento = eventoDAO.get(idEvento);
        if ((entradaDAO.getAforoOcupado(evento) + numEntradas) > evento.getAforo()) {
            return ERROR;
        } else {
            precioTotal = (float) numEntradas * evento.getPrecio();
            return SUCCESS;
        }
    }

}

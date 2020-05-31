/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.entradas;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import modelo.dao.entradaDAO;
import modelo.dao.eventoDAO;
import modelo.dao.ofertaDAO;
import modelo.entidades.Evento;
import modelo.entidades.Oferta;
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
    private float descuento;

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

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
        eventoDAO eventoDAO = new eventoDAO();
        ofertaDAO ofertaDAO = new ofertaDAO();
        evento = eventoDAO.get(idEvento);
        Oferta oferta = ofertaDAO.getOfertaEvento(evento);
        Date hoy = new Date();
        if(oferta != null && (hoy.after(oferta.getTInicio()) && hoy.before(oferta.getTFin()))){
            precioTotal = (float) numEntradas * evento.getPrecio() * (1 - oferta.getDescuento()/100);
            descuento = oferta.getDescuento();
        }else{
        
        /*if ((entradaDAO.getAforoOcupado(evento) + numEntradas) > evento.getAforo()) {
            return ERROR;
        } else {*/
            precioTotal = (float) numEntradas * evento.getPrecio();
            descuento = -1;
        }
            return SUCCESS;
        //}
    }

}

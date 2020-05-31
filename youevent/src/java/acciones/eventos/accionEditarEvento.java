/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.eventos;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import modelo.dao.eventoDAO;
import modelo.entidades.Evento;
import modelo.entidades.Usuario;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class accionEditarEvento extends ActionSupport implements SessionAware {

    private Integer id;
    private String nombre;
    private String descripcion;
    private String lugar;
    private int aforo;
    private float precio;
    private String fecha;
    private Map<String, Object> session;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public accionEditarEvento() {
    }

    public String execute() throws Exception {

        eventoDAO eventoDAO = new eventoDAO();

        Date fechaDate =new SimpleDateFormat("dd/MM/yyyy").parse(fecha); 
        
        Usuario usuario = (Usuario) session.get("usuario");
        System.out.println(usuario.getId());
        Evento evento = new Evento(usuario.getId(), nombre, descripcion, lugar, aforo, precio, fechaDate);
        evento.setId(id);
        eventoDAO.editar(evento);

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

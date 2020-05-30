/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.eventos;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import modelo.dao.categoriaDAO;
import modelo.dao.eventoCategoriaDAO;
import modelo.dao.eventoDAO;
import modelo.entidades.Categoria;
import modelo.entidades.Evento;
import modelo.entidades.EventoCategoria;
import modelo.entidades.EventoCategoriaId;
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

    public accionEditarEvento() {
    }

    public String execute() throws Exception {

        eventoDAO eventoDAO = new eventoDAO();

        Usuario usuario = (Usuario) session.get("usuario");
        Evento evento = new Evento(usuario.getId(), nombre, descripcion, lugar);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.eventos;

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
public class accionCrearEvento extends ActionSupport implements SessionAware {

    private String nombre;
    private String descripcion;
    private String lugar;
    private List<Categoria> categorias = new ArrayList();
    private List<String> categoriasEvento = new ArrayList();
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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategories(List<Categoria> categories) {
        this.categorias = categories;
    }

    public accionCrearEvento() {
        categoriaDAO categoriaDAO = new categoriaDAO();
        this.categorias = categoriaDAO.getAllCategorias();
    }

    public String execute() throws Exception {

        eventoDAO eventoDAO = new eventoDAO();

        if (eventoDAO.comprobarNombreRepetido(this.nombre) == true) {
            return ERROR;
        } else {
            Usuario usuario = (Usuario) session.get("usuario");
            Evento evento = new Evento(usuario.getId(), nombre, descripcion, lugar);
            eventoDAO.crear(evento);
            evento = eventoDAO.get(evento.getId());

            eventoCategoriaDAO ecDAO = new eventoCategoriaDAO();

            //System.out.println(categories.toString());
            categoriaDAO cdao = new categoriaDAO();
            Iterator<String> it = categoriasEvento.iterator();
            while (it.hasNext()) {
                Categoria c = cdao.getById(categorias, Integer.parseInt(it.next()));
                EventoCategoriaId ecId = new EventoCategoriaId(evento.getId(), c.getId());
                EventoCategoria ec = new EventoCategoria(ecId, c, evento);
                ecDAO.crear(ec);
            }

            return SUCCESS;
        }

    }

    public List<String> getCategoriasEvento() {
        return categoriasEvento;
    }

    public void setCategoriasEvento(List<String> categoriasEvento) {
        this.categoriasEvento = categoriasEvento;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void validate() {

    }

}

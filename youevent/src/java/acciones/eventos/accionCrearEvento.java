/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.eventos;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private int aforo;
    private float precio;
    private String fecha;
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
            Date fechaDate =new SimpleDateFormat("dd/MM/yyyy").parse(fecha); 
            Evento evento = new Evento(usuario.getId(), nombre, descripcion, lugar, aforo, precio, fechaDate);
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
        String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(this.fecha);
        if(!matcher.matches()){
            addFieldError("fecha", "La fecha debe tener el siguiente formato: dd/mm/YYYY");
        }
        
        if(this.nombre.length() == 0){
            addFieldError("nombre", "El nombre no puede estar vacío");
        }
        
        if(this.nombre.length() > 20){
            addFieldError("nombre", "El nombre no puede contener mas de 20 caracteres");
        }
        
        if(!Pattern.matches("^[a-zA-Z ]*$", this.nombre)){
            addFieldError("nombre", "El nombre debe contener caracteres alfabéticos");
        }
        
        if (this.descripcion.length() == 0) {
            addFieldError("descripcion", "La descripción no puede estar vacía");
        }
        
        if(this.descripcion.length() > 255){
            addFieldError("descripcion", "La descripción no puede contener más de 255 caracteres");
        }
        
        if(!Pattern.matches("^[a-zA-Z0-9_,. ]*$", this.descripcion)){
            addFieldError("descripcion", "La descripción debe contener caracteres alfanuméricos");
        }
        
        if (this.lugar.length() == 0) {
            addFieldError("lugar", "Introduzca un lugar");
        }
        
        if(!Pattern.matches("^[a-zA-Z0-9_, ]*$", this.lugar)){
            addFieldError("lugar", "El lugar debe contener caracteres alfanuméricos");
        }
        
        if(this.lugar.length() > 30){
            addFieldError("lugar", "El lugar no puede contener más de 30 caracteres");
        }
        
        if(!Pattern.matches("^([+]?\\d*\\.?\\d*)$", Float.toString(precio))){
            addFieldError("precio", "El precio es incorrecto");
        }
        
        if(!Pattern.matches("\\d+", Integer.toString(aforo))){
            addFieldError("precio", "El aforo es incorrecto");
        }
        

    }

}

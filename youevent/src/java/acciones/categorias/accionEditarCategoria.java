/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.categorias;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import modelo.dao.categoriaDAO;
import modelo.entidades.Categoria;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class accionEditarCategoria extends ActionSupport implements SessionAware {

    private Integer id;
    private String nombre;
    private String descripcion;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public accionEditarCategoria() {
    }

    @Override
    public String execute() throws Exception {

        categoriaDAO catDAO = new categoriaDAO();
        
        Categoria cat = new Categoria(nombre, descripcion);
        cat.setId(id);
        
        catDAO.editar(cat);

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

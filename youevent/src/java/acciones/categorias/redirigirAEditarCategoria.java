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
import modelo.dao.eventoDAO;
import modelo.entidades.Categoria;
import modelo.entidades.Evento;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class redirigirAEditarCategoria extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    private Categoria categoria;
    private Integer idCategoria;


    
    public redirigirAEditarCategoria() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    
    public String execute() throws Exception {
        categoriaDAO catDAO = new categoriaDAO();
        this.categoria = catDAO.get(idCategoria); 
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}

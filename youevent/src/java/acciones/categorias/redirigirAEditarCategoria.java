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
<<<<<<< HEAD
    private int idCategoria;
=======
    private Integer idCategoria;
>>>>>>> 18eb5ef53ef74043b3908a05902e5118310f7d61


    
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

<<<<<<< HEAD
    public void setIdCategoria(int idCategoria) {
=======
    public void setIdCategoria(Integer idCategoria) {
>>>>>>> 18eb5ef53ef74043b3908a05902e5118310f7d61
        this.idCategoria = idCategoria;
    }

    
    public String execute() throws Exception {
<<<<<<< HEAD
        categoria = new categoriaDAO().get(idCategoria); 
=======
        categoriaDAO catDAO = new categoriaDAO();
        this.categoria = catDAO.get(idCategoria); 
>>>>>>> 18eb5ef53ef74043b3908a05902e5118310f7d61
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}

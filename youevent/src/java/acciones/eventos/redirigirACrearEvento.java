/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.eventos;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import modelo.dao.categoriaDAO;
import modelo.entidades.Categoria;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class redirigirACrearEvento extends ActionSupport implements SessionAware{

    private Map<String, Object> session;
    private List<Categoria> categorias;


    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    

    public redirigirACrearEvento() {
    }

    public String execute() throws Exception {
        categoriaDAO categoriaDAO = new categoriaDAO();
        this.categorias = categoriaDAO.getAllCategorias();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

}

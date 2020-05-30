/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.categorias;


import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.dao.categoriaDAO;
import modelo.dao.eventoDAO;
import modelo.entidades.Categoria;


/**
 *
 * @author Carlos
 */
public class redirigirAListarCategoria extends ActionSupport {

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
    
    private List<Categoria> listaCategorias;

    
    public redirigirAListarCategoria() {
    }
    
    @Override
    public String execute() throws Exception {
        listaCategorias = new categoriaDAO().getAllCategorias();
        return SUCCESS;
    }
    
}

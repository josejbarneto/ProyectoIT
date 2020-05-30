/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.categorias;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.categoriaDAO;
import modelo.entidades.Categoria;

/**
 *
 * @author Carlos
 */
public class redirigirAMostrarCategoria extends ActionSupport {
    
    private Integer idCategoria;
    private Categoria categoria;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public redirigirAMostrarCategoria() {
    }
    
    public String execute() throws Exception {
        categoriaDAO catDAO = new categoriaDAO();
        categoria = catDAO.get(idCategoria);
        return SUCCESS;
    }
    
}

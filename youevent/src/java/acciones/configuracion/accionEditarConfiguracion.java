/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.configuracion;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.dao.configuracionDAO;
import modelo.entidades.Categoria;
import modelo.entidades.Configuracion;

/**
 *
 * @author Carlos
 */
public class accionEditarConfiguracion extends ActionSupport {
    
    private boolean modeoNocturno;
    private boolean openNewTab;
    private int id_categoria;
    private int idConfiguracion;
    private List<Categoria> listaCategorias;

    public boolean isModeoNocturno() {
        return modeoNocturno;
    }

    public void setModeoNocturno(boolean modeoNocturno) {
        this.modeoNocturno = modeoNocturno;
    }

    public boolean isOpenNewTab() {
        return openNewTab;
    }

    public void setOpenNewTab(boolean openNewTab) {
        this.openNewTab = openNewTab;
    }



    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
    
    
    
    public accionEditarConfiguracion() {
    }
    
    public String execute() throws Exception {
        configuracionDAO configuracionDAO = new configuracionDAO();
        Configuracion configuracion = configuracionDAO.get(idConfiguracion);
        configuracion.setIdCategoriaInicial(id_categoria);
        configuracion.setModoNocturno(modeoNocturno);
        configuracion.setOpenNewTab(openNewTab);
        configuracionDAO.edit(configuracion);
        return SUCCESS;
    }
    
}

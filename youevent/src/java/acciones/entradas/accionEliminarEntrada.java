/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.entradas;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.entradaDAO;

/**
 *
 * @author Fran
 */
public class accionEliminarEntrada extends ActionSupport {

    private Integer idEntrada;

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public accionEliminarEntrada() {
    }

    public String execute() throws Exception {
        entradaDAO entradaDAO = new entradaDAO();
        entradaDAO.eliminar(idEntrada);
        return SUCCESS;
    }

}

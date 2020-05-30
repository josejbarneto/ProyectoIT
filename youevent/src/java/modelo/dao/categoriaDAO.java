/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidades.Categoria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class categoriaDAO {

    Session sesion = null;

    public List<Categoria> getAllCategorias() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Categoria");
        List<Categoria> c = (List<Categoria>) q.list();
        tx.commit();
        return c;
    }

    public Categoria getById(List<Categoria> lista, Integer id) {
        for (Categoria categoria : lista) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }
}

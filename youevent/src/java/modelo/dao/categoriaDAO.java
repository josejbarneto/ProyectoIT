/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidades.Categoria;
import org.hibernate.HibernateException;
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
    
    public Categoria get(int id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Categoria where id='" + id + "'");
        Categoria c = (Categoria) q.uniqueResult();
        tx.commit();
        return c;
    }
    
    public int insertaCategoria(Categoria cat){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        int res = (int)sesion.save(cat);
        tx.commit();
        
        return res;
    
    }
    
    public void editar(Categoria cat) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(cat);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public boolean existeCategoria(String nombre) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Categoria where nombre='" + nombre + "'");
        Categoria c = (Categoria) q.uniqueResult();
        tx.commit();
        
        if (c != null) {
            return true;
        } else {
            return false;
        }
        
    }
}

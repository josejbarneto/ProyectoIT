/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import modelo.entidades.Evento;
import modelo.entidades.Oferta;
import modelo.entidades.Usuario;

/**
 *
 * @author Fran
 */
public class ofertaDAO {
    
    Session sesion = null;

    public int crear(Oferta oferta) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        int res = (int) sesion.save(oferta);
        tx.commit();
        return res;
    }

    public Oferta get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Oferta where id='" + id + "'");
        Oferta e = (Oferta) q.uniqueResult();
        tx.commit();
        return e;
    }

    public void editar(Oferta oferta) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(oferta);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Oferta> getOfertas() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Oferta");
        List<Oferta> le = (List<Oferta>) q.list();
        tx.commit();
        return le;
    }

    public void eliminar(Integer idOferta) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("delete from Oferta where id='" + idOferta + "'");
        q.executeUpdate();
        tx.commit();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidades.Anunciante;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class anuncianteDAO {

    Session sesion = null;

    public void crear(Anunciante anunciante) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        int res = (int) sesion.save(anunciante);
        tx.commit();
    }

    public List<Anunciante> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anunciante");
        List<Anunciante> le = (List<Anunciante>) q.list();
        tx.commit();
        return le;
    }

    public Anunciante get(int idAnunciante) {
        System.out.println(idAnunciante);
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anunciante where id = "+idAnunciante);
        Anunciante a = (Anunciante) q.uniqueResult();
        System.out.println(a.getNombre());
        tx.commit();
        return a;
    }

    public void editar(Anunciante anunciante) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(anunciante);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void eliminar(int idAnunciante) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("delete from Anunciante where id  = " + idAnunciante);
        q.executeUpdate();
        tx.commit();    
    }

}

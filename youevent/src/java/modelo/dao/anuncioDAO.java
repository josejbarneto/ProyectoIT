/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidades.Anuncio;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class anuncioDAO {

    Session sesion = null;

    public List<Anuncio> getByIdAnunciante(int idAnunciante) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncio where id_anunciante = "+idAnunciante);
        List<Anuncio> la = (List<Anuncio>) q.list();
        tx.commit();
        return la;
    }
    
    public void crear(Anuncio anuncio) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        int res = (int) sesion.save(anuncio);
        tx.commit();
    }
    
    public List<Anuncio> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncio");
        List<Anuncio> la = (List<Anuncio>) q.list();
        tx.commit();
        return la;
    }
    
    public Anuncio get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncio where id='" + id + "'");
        Anuncio a = (Anuncio) q.uniqueResult();
        tx.commit();
        return a;
    }
    
    public void editar(Anuncio anuncio) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(anuncio);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void eliminar(Integer idAnuncio) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("delete from Anuncio where id  = "+idAnuncio);
        q.executeUpdate();
        tx.commit();

    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidades.Anunciante;
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
    
    public List<Anunciante> getAllAnunciantes() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anunciante");
        List<Anunciante> a = (List<Anunciante>) q.list();
        tx.commit();
        return a;
    }
}

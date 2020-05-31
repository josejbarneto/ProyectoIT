/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.entidades.Configuracion;
import modelo.entidades.Evento;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eugen
 */
public class configuracionDAO {

    Session sesion = null;

    public void insertConfiguracion(Configuracion conf) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(conf);
        tx.commit();
    }

    public Configuracion get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Configuracion where id_usuario='" + id + "'");
        Configuracion c = (Configuracion) q.uniqueResult();
        tx.commit();
        return c;
    }
}

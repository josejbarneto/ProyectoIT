/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.entidades.Categoria;
import modelo.entidades.Evento;
import modelo.entidades.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class eventoDAO {

    Session sesion = null;

    public boolean comprobarNombreRepetido(String nombre) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Evento where nombre='" + nombre + "'");
        Evento e = (Evento) q.uniqueResult();
        tx.commit();
        
        if (e != null) {
            return true;
        } else {
            return false;
        }
    }

    public int crear(Evento evento) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        int res = (int) sesion.save(evento);
        tx.commit();
        return res;
    }

    public Evento get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Evento where id='" + id + "'");
        Evento e = (Evento) q.uniqueResult();
        tx.commit();
        return e;
    }

}
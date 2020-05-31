/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidades.Entrada;
import modelo.entidades.Evento;
import modelo.entidades.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fran
 */
public class entradaDAO {

    Session sesion = null;

    public int crear(Entrada entrada) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        int res = (int) sesion.save(entrada);
        tx.commit();
        return res;
    }

    public Entrada get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Entrada where id='" + id + "'");
        Entrada e = (Entrada) q.uniqueResult();
        tx.commit();
        return e;
    }

    public void editar(Entrada entrada) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(entrada);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Entrada> getEntradasUsuario(Usuario usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Entrada where id_usuario='" + usuario.getId() + "'");
        List<Entrada> le = (List<Entrada>) q.list();
        tx.commit();
        return le;
    }

    public void eliminar(Integer idEntrada) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("delete from Entrada where id='" + idEntrada + "'");
        q.executeUpdate();
        tx.commit();
    }

    public int getAforoOcupado(Evento evento) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("select count(id) from Entrada where id_evento='" + evento.getId() + "'");
        int e = (int) q.uniqueResult();
        tx.commit();
        return e;
    }
}

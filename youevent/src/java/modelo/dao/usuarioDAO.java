package modelo.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import modelo.entidades.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class usuarioDAO {

    Session sesion = null;

    public Usuario comprobarLogin(String username, String password) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where usuario='" + username + "' and password='" + password + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }

    public boolean existeUsuario(String usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where usuario='" + usuario + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        if (u != null) {
            return false;
        } else {
            return true;
        }
    }

    public void insertUsuario(Usuario usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(usuario);
        tx.commit();
    }

}

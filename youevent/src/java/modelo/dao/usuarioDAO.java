package modelo.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import modelo.entidades.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Carlos
 */
public class usuarioDAO {

    Session sesion = null;

    public Usuario comprobarLogin(String username, String password) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where usuario='" + username+"'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        
        if(u!=null){
            if(BCrypt.checkpw(password, u.getContrasenya())){
                return u;
            }
        }
        return null;
    }

    public boolean existeUsuario(String usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where usuario='" + usuario + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        
        if (u != null) {
            return true;
        } else {
            return false;
        }
        
    }
    
    public void updatePass(Usuario usuario, String pass){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("Update Usuario set contrasenya = '" + pass + "' where id = '" + usuario.getId() + "'");
        q.executeUpdate();
        tx.commit();
        
    }
    
    public List<Usuario> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario");
        List<Usuario> us = (List<Usuario>) q.list();
        tx.commit();
        return us;
    }
    
    public Usuario get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where id='" + id + "'");
        Usuario a = (Usuario) q.uniqueResult();
        tx.commit();
        return a;
    }
    
    public void editar(Usuario us) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(us);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    

    public int insertUsuario(Usuario usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        int res = (int)sesion.save(usuario);
        tx.commit();
        return res;
    }
    
    public Usuario comprobarCorreo(String email) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where email='" + email+"'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        
        return u;
    } 

    public void eliminar(Integer idUsuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("delete from Usuario where id  = "+idUsuario);
        q.executeUpdate();
        tx.commit();
    }

}

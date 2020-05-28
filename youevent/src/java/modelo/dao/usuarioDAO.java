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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.Date;
import modelo.entidades.ClaveTemporal;
import modelo.entidades.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eugen
 */
public class claveTemporalDAO {
    
    Session sesion = null;
    
    public int insertaClaveTemporal(Usuario us, String clave){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        
        Query q = sesion.createQuery("delete ClaveTemporal where id_usuario = '" + us.getId() + "'");
        q.executeUpdate();
        
        ClaveTemporal ct = new ClaveTemporal();
        ct.setUsuario(us);
        ct.setContrasenya(clave);
        ct.setFechaDeCreacion(new Date());
        int res = (int)sesion.save(ct);
        tx.commit();
        return res;
    }
    
    public Usuario compruebaClaveTemporal(String us, String pass){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Usuario where usuario = '" + us + "'");
        Usuario res = (Usuario) q.uniqueResult();
        
        q = sesion.createQuery("From ClaveTemporal where contrasenya = '" + pass + "'");
        ClaveTemporal aux = (ClaveTemporal) q.uniqueResult();
        tx.commit();
        
        if(aux!=null){
            return res;
        }
        return null;
    }
}

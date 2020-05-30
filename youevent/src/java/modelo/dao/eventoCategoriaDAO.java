/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.entidades.Evento;
import modelo.entidades.EventoCategoria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class eventoCategoriaDAO {
        Session sesion = null;
    
        public int crear(EventoCategoria ec) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        int res = (int) sesion.save(ec);
        tx.commit();
        return res;
    }

}

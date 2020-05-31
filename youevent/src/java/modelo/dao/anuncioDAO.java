/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidades.Anunciante;
import modelo.entidades.Anuncio;
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
}

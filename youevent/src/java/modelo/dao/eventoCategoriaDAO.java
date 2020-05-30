/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Categoria;
import modelo.entidades.Evento;
import modelo.entidades.EventoCategoria;
import modelo.entidades.EventoCategoriaId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos
 */
public class eventoCategoriaDAO {

    Session sesion = null;

    public EventoCategoriaId crear(EventoCategoria ec) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        EventoCategoriaId res = (EventoCategoriaId) sesion.save(ec);
        tx.commit();
        return res;
    }

    public List<Categoria> getCategorias(Evento evento) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From EventoCategoria where id_evento="+ evento.getId());
        List<EventoCategoria> listaEventoCategoria = (List<EventoCategoria>) q.list();
        tx.commit();
        
        List<Categoria> listaCategoria = new ArrayList<>();
        
        for(EventoCategoria ec : listaEventoCategoria){
            listaCategoria.add(ec.getCategoria());
        }
        
        return listaCategoria;
    }

}

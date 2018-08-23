/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.catalogos.TipoCatalogo;
import ec.gob.arcom.auditoresmineros.persistencia.daos.TipoCatalogoSBLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mejiaw
 */
@Stateless
public class TipoCatalogoSB implements TipoCatalogoSBLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(TipoCatalogo tipoCatalogo) {
        em.persist(tipoCatalogo);
    }

    @Override
    public void update(TipoCatalogo tipoCatalogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TipoCatalogo tipoCatalogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoCatalogo find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoCatalogo> list() {
        try {
            Query query= em.createQuery("Select tc from TipoCatalogo tc");
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public TipoCatalogo findByDescripcion(String descripcion) {
        try {
            Query query= em.createQuery("Select tc from TipoCatalogo tc where tc.descripcion= :descripcion");
            query.setParameter("descripcion", descripcion);
            return (TipoCatalogo) query.getSingleResult();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public TipoCatalogo findByNemonico(String nemonico) {
        try {
            Query query= em.createQuery("Select tc from TipoCatalogo tc where tc.activo= :activo and tc.nemonico= :nemonico");
            query.setParameter("activo", true);
            query.setParameter("nemonico", nemonico);
            return (TipoCatalogo) query.getResultList().get(0);
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
}

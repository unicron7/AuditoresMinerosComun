/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import ec.gob.arcom.auditoresmineros.persistencia.daos.CatalogoSBLocal;
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
public class CatalogoSB implements CatalogoSBLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Catalogo catalogo) {
        em.persist(catalogo);
    }

    @Override
    public void update(Catalogo catalogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Catalogo catalogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Catalogo find(Long id) {
        return this.em.find(Catalogo.class, id);
    }
    
    @Override
    public Catalogo findByName(String name) {
        try {
            Query query= em.createQuery("Select cat from Catalogo cat where cat.activo= :activo and cat.nombre= :name");
            query.setParameter("activo", true);
            query.setParameter("name", name);
            return (Catalogo)query.getResultList().get(0);
        } catch(Exception ex) {
           System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public List<Catalogo> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public List<Catalogo> listByTipo(Long tipoCatalogoId) {
        try {
            Query query= em.createQuery("Select c from Catalogo c where c.tipoCatalogoId= :tipocatalogoid and c.activo= :estado order by c.nombre asc");
            query.setParameter("tipocatalogoid", tipoCatalogoId);
            query.setParameter("estado", true);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }*/

    @Override
    public List<Catalogo> listByTipoCatalogo(Long pk) {
        try {
            Query query= em.createQuery("Select cat from Catalogo cat where cat.activo= :activo and cat.tipoCatalogo.id= :tipoCatalogoId");
            query.setParameter("activo", true);
            query.setParameter("tipoCatalogoId", pk);
            return query.getResultList();
        } catch(Exception ex) {
           System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public Catalogo findByNemonico(String nemonico) {
        try {
            Query query= em.createQuery("Select cat from Catalogo cat where cat.activo= :activo and cat.nemonico= :nemonico");
            query.setParameter("activo", true);
            query.setParameter("nemonico", nemonico);
            return (Catalogo) query.getResultList().get(0);
        } catch(Exception ex) {
           System.out.println("No se puede obtener el catalogo" + ex.toString());
        }
        return null;
    }
}

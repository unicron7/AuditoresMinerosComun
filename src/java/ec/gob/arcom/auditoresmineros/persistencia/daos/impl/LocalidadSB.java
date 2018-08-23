/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.persistencia.daos.LocalidadSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Localidad;
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
public class LocalidadSB implements LocalidadSBLocal {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Localidad> listProvincia() {
        Query query = em.createNamedQuery("Localidad.listarLocalidades").setParameter("tipo", Localidad.PROVINCIA);
        return query.getResultList();
    }

    @Override
    public List<Localidad> listCanton(String codigo) {
        Query query= em.createQuery("Select l from Localidad l where l.padre=?1");
        query.setParameter(1, codigo);
        return query.getResultList();
    }

    @Override
    public List<Localidad> listParroquia(String codigo) {
        Query query= em.createQuery("Select l from Localidad l where l.padre=?1");
        query.setParameter(1, codigo);
        return query.getResultList();
    }
    
    @Override
    public Localidad find(Long id) {
        return em.find(Localidad.class, id);
    }
    
    @Override
    public Localidad findByCodigoInec(String codigoInec) {
        Query query= em.createQuery("Select l from Localidad l where l.codigoInec= :codigoInec");
        query.setParameter("codigoInec", codigoInec);
        return (Localidad) query.getResultList().get(0);
    }
}

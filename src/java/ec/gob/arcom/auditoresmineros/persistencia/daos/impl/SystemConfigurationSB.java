/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.config.SystemConfiguration;
import ec.gob.arcom.auditoresmineros.persistencia.daos.SystemConfigurationSBLocal;
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
public class SystemConfigurationSB implements SystemConfigurationSBLocal {
    @PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public SystemConfiguration findByKey(String key) {
        try {
            Query query= em.createQuery("Select sc from SystemConfiguration sc where sc.configKey= :key");
            query.setParameter("key", key);
            return (SystemConfiguration) query.getSingleResult();
        } catch(Exception ex) {
            return null;
        }
    }
    
    @Override
    public void update(SystemConfiguration config) {
        this.em.merge(config);
    }
    
    @Override
    public List<SystemConfiguration> list() {
        try {
            Query query= em.createQuery("Select sc from SystemConfiguration sc");
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
}

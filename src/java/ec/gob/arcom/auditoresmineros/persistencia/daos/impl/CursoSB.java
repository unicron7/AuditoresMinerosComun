/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.persistencia.daos.CursoSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Curso;
import java.util.Calendar;
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
public class CursoSB implements CursoSBLocal {
    @PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public void save(Curso curso) {
        curso.setActivo(true);
        this.em.persist(curso);
    }

    @Override
    public void update(Curso curso) {
        curso.setFechaActualizacion(Calendar.getInstance().getTime());
        this.em.merge(curso);
    }

    @Override
    public void delete(Curso curso) {
        curso.setActivo(false);
        curso.setFechaActualizacion(Calendar.getInstance().getTime());
        this.em.merge(curso);
    }

    @Override
    public Curso find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> list() {
        try {
            Query query= em.createQuery("Select c from Curso c");
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public List<Curso> listByEstado() {
        try {
            Query query= em.createQuery("Select c from Curso c where c.activo= 'true' order by c.id");
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    @Override
    public List<Curso> findByName(String nombre) {
        try {
            Query query= em.createQuery("Select c from Curso c where lower(c.nombre) like lower(:name)");
            query.setParameter("name","%" + nombre + "%");
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.persistencia.entidades.Curso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface CursoSBLocal {
    void save(Curso curso);
    void update(Curso curso);
    void delete(Curso curso);
    Curso find(Long id);
    List<Curso> list();
    List<Curso> listByEstado();
    List<Curso> findByName(String nombre);
}

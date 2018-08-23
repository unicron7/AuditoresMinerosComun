/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.persistencia.entidades.ConcesionMinera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface ConcesionMineraSBLocal {

    List listConcesionMinera();

    List listConcesionMinera(String cr);

    ConcesionMinera findById(Long id);

    List<ConcesionMinera> listConcesionMinera(String cr, Long tipo1, Long tipo2, Long tipo3);
    
}

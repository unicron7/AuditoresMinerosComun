/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.persistencia.entidades.ProfesionalAuditorExterno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface ProfesionalAuditorSBLocal {

    void savePAE(ProfesionalAuditorExterno profesionalAuditorExterno);

    ProfesionalAuditorExterno findByRuc(String ruc);
    
    List<ProfesionalAuditorExterno> findByRuc(String ruc, String criterio);

    List<ProfesionalAuditorExterno> listarPAE();
    
    List<ProfesionalAuditorExterno> listarPAEActivo();

    void updatePAE(ProfesionalAuditorExterno profesionalAuditorExterno);

    ProfesionalAuditorExterno findById(Long id);
    
    ProfesionalAuditorExterno getPAEJoinFetchPago(Long id);
}
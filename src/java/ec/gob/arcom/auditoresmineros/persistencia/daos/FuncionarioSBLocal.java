/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.persistencia.entidades.Funcionario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface FuncionarioSBLocal {
    void save(Funcionario funcionario);
    void update(Funcionario funcionario);
    void delete(Funcionario funcionario);
    Funcionario find(Long id);
    List<Funcionario> list();
    Funcionario findByUserName(String userName);
    List<Funcionario> findByApellido(String apellido);
    
}

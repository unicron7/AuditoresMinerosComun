/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.persistencia.entidades.Usuario;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface UsuarioSBLocal {

    Usuario findByLogin(String login);
    
}

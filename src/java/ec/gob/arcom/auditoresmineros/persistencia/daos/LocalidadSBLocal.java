/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.persistencia.entidades.Localidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface LocalidadSBLocal {

    List listProvincia();

    List listCanton(String codigo);

    List listParroquia(String codigo);
    
    Localidad find(Long id);
    Localidad findByCodigoInec(String codigoInec);
}

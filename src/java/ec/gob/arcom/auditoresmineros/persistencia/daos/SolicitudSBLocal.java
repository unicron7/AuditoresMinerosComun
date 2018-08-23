/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface SolicitudSBLocal {
    void create(Object obj);
    Object read(Long pk);
    void update(Object obj);
    void delete(Object obj);
    List list();
    List list(String documento);
}

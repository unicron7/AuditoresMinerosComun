/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.config.SystemConfiguration;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface SystemConfigurationSBLocal {
    SystemConfiguration findByKey(String key);
    void update(SystemConfiguration config);
    List<SystemConfiguration> list();
}

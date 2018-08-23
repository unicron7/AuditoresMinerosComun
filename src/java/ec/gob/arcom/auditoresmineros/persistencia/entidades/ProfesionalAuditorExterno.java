/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Will
 */
@Entity
@Table(schema = "audmin")
@NamedQueries({
    @NamedQuery(name="ProfesionalAuditorExterno.listAll",
            query = "SELECT pnat FROM ProfesionalAuditorExterno pnat")
})
@Data
public class ProfesionalAuditorExterno extends Auditor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String titulo;
    private String registroSenescyt;
}

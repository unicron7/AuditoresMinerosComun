/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Will
 */
@Entity
@Table(schema = "audmin")
@NamedQueries({
    @NamedQuery(name="EmpresaConsultoraAuditoria.listAll",
            query = "SELECT pjur FROM EmpresaConsultoraAuditoria pjur")
})
@Data
public class EmpresaConsultoraAuditoria extends Auditor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(schema = "audmin")
    private List<Colaborador> colaboradores;
}

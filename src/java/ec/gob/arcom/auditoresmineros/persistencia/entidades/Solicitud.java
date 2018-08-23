/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author mejiaw
 */
@Entity
@Table(schema = "audmin")
@Data
public class Solicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaSolicitud;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaSolicitud;
    
    private String documentoTitular;
    
    @ManyToOne
    @JoinColumn(name = "concesionMinera", referencedColumnName = "codigo_concesion")
    private ConcesionMinera concesionMinera;
    
    @ManyToOne
    @JoinColumn(name = "opcion1", referencedColumnName = "id")
    private Auditor opcion1;
    
    @ManyToOne
    @JoinColumn(name = "opcion2", referencedColumnName = "id")
    private Auditor opcion2;
    
    @ManyToOne
    @JoinColumn(name = "opcion3", referencedColumnName = "id")
    private Auditor opcion3;
    
    @ManyToOne
    @JoinColumn(name = "seleccion", referencedColumnName = "id")
    private Auditor seleccion;
    
    private Long tipoAuditoria;
    private String observacion;
    private boolean activo;
    
}

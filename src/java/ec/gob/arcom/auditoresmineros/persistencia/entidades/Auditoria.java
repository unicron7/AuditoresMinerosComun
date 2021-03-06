/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.entidades;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import ec.gob.arcom.auditoresmineros.util.DateUtil;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //Constantes de los nemonicos del estado de la auditoria
    public static final String VIGENTE= "ESTVIG";
    public static final String FINALIZADO= "ESTFIN";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JoinColumn(name = "auditor", referencedColumnName = "id")
    @ManyToOne
    private Auditor auditor;
    
    @ManyToOne
    @JoinColumn(name = "concesionMinera", referencedColumnName = "codigo_concesion")
    private ConcesionMinera concesionMinera;
    
    private String documentoTitular;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDeAsignacion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaDeAsignacion;
    
    @JoinColumn(name = "tipoAuditoria", referencedColumnName = "id")
    @ManyToOne
    private Catalogo tipoAuditoria;
    
    private String observacion;
    private boolean activo;
    
    @JoinColumn(name = "solicitud", referencedColumnName = "id")
    @OneToOne
    private Solicitud solicitud;
    
    @JoinColumn(name = "estadoAuditoria", referencedColumnName = "id")
    @ManyToOne
    private Catalogo estadoAuditoria;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDeFinalizacion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaDeFinalizacion;
    
    public String obtenerFecha() {
        return DateUtil.obtenerFechaConFormato(fechaDeAsignacion);
    }
}

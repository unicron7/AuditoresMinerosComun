/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.entidades;

import ec.gob.arcom.auditoresmineros.util.DateUtil;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author Will
 */
@Entity
@Table(schema = "audmin")
@Data
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String entidadFinanciera;
    private String numeroDeposito;
    private Double valorDeposito;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDeposito;
    
    public String obtenerValor() {
        return obtenerValorConFormato("##0.00", valorDeposito);
    }
    
    public String obtenerValorConFormato(String formato, Double valor) {
        DecimalFormat df= new DecimalFormat(formato);
        return df.format(valor);
    }
    
    public String obtenerFecha() {
        return DateUtil.obtenerFechaConFormato(fechaDeposito);
    }
}

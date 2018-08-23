/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author mejiaw
 */
@Entity
//@Table(name="audmin.localidad")
@Table(schema = "audmin")
@NamedQueries({
    @NamedQuery(name="Localidad.listarLocalidades",
            query = "FROM Localidad l WHERE l.tipo= :tipo ORDER BY l.nombre ASC")
})
@Data
public class Localidad implements Serializable {
    //Constantes del tipo de localidad
    public static final Long PAIS= (long) 1;
    public static final Long PROVINCIA= (long) 2;
    public static final Long CANTON= (long) 3;
    public static final Long PARROQUIA= (long) 4;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoInec;
    private String nombre;
    private Long tipo;
    private String padre;
    
}

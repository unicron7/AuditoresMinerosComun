/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author mejiaw
 */
public class FileUploadController {
    //private static String destino="D:\\adjuntos\\";
    
    public static String obtenerExtArchivo(String fileName) {
        String tmp= "";
        StringTokenizer st= new StringTokenizer(fileName, ".");
        while (st.hasMoreTokens()) {
            tmp= st.nextToken();
            if(st.countTokens()==0)
                return tmp;
        }
        return tmp;
    }
    
    public static boolean verificarTipoArchivo(String ext) {
        if(ext.equalsIgnoreCase("DOC") || ext.equalsIgnoreCase("DOCX") || ext.equalsIgnoreCase("PDF")) {
            return true;
        }
        return false;
    }
    
    public static boolean verificarArchivoRepetido(String fileName, List<UploadedFile> fileList) {
        for (UploadedFile uf : fileList) {
            if(uf.getFileName().equalsIgnoreCase(fileName))
                return true;
        }
        return false;
    }
    
    public static String getSizeMB(long size) {
        Double tmp= (double)size/1048576;
        DecimalFormat df= new DecimalFormat("#.##");
        return df.format(tmp)+"MB";
    }
    
    public static String obtenerDestino(String ruc) {
        // Crear carpeta con el numero del ruc
        String adjuntoPath="";
        Properties propertiesFile= new Properties();
        try {
            propertiesFile.load(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/sram/config.properties"));
            if(System.getProperty("file.separator").equals("/")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathunix");
                new File(adjuntoPath+ruc).mkdir();
            } else if(System.getProperty("file.separator").equals("\\")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathwin");
                new File(adjuntoPath+ruc).mkdir();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ruta a guardar archivo: " + adjuntoPath);
        return adjuntoPath+ruc+System.getProperty("file.separator");
    }
    
    public static String obtenerDestinoCertificado(String ruc) {
        // Crear carpeta llamada certificado dentro de la carpeta del número de ruc para almacernar el certificado del curso
        String adjuntoPath="";
        Properties propertiesFile= new Properties();
        try {
            propertiesFile.load(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/sram/config.properties"));
            if(System.getProperty("file.separator").equals("/")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathunix");
                new File(adjuntoPath+ruc+System.getProperty("file.separator")+"certificado").mkdir();
            } else if(System.getProperty("file.separator").equals("\\")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathwin");
                new File(adjuntoPath+ruc+System.getProperty("file.separator")+"certificado").mkdir();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adjuntoPath+ruc+System.getProperty("file.separator")+"certificado"+System.getProperty("file.separator");
    }
    
    public static String obtenerDestinoInforme(String ruc) {
        // Crear carpeta llamada resolucion dentro de la carpeta del número de ruc para almacernar la resolucion de calificacion
        String adjuntoPath="";
        Properties propertiesFile= new Properties();
        try {
            propertiesFile.load(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/sram/config.properties"));
            if(System.getProperty("file.separator").equals("/")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathunix");
                new File(adjuntoPath+ruc+System.getProperty("file.separator")+"informe").mkdir();
            } else if(System.getProperty("file.separator").equals("\\")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathwin");
                new File(adjuntoPath+ruc+System.getProperty("file.separator")+"informe").mkdir();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adjuntoPath+ruc+System.getProperty("file.separator")+"informe"+System.getProperty("file.separator");
    }
    
    public static String obtenerDestinoResolucion(String ruc) {
        // Crear carpeta llamada resolucion dentro de la carpeta del número de ruc para almacernar la resolucion de calificacion
        String adjuntoPath="";
        Properties propertiesFile= new Properties();
        try {
            propertiesFile.load(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/sram/config.properties"));
            if(System.getProperty("file.separator").equals("/")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathunix");
                new File(adjuntoPath+ruc+System.getProperty("file.separator")+"resolucion").mkdir();
            } else if(System.getProperty("file.separator").equals("\\")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathwin");
                new File(adjuntoPath+ruc+System.getProperty("file.separator")+"resolucion").mkdir();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adjuntoPath+ruc+System.getProperty("file.separator")+"resolucion"+System.getProperty("file.separator");
    }
    
    public static String obtenerDestinoInfAuditoria(String idAuditoria) {
        // Crear carpeta cuyo nombre sea el número de id de auditoria para almacenar el informe de la auditoria
        String path="";
        Properties propertiesFile= new Properties();
        try {
            propertiesFile.load(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/sram/config.properties"));
            if(System.getProperty("file.separator").equals("/")) {
                path= propertiesFile.getProperty("infauditoriapathunix");
                new File(path+System.getProperty("file.separator")+idAuditoria).mkdir();
            } else if(System.getProperty("file.separator").equals("\\")) {
                path= propertiesFile.getProperty("infauditoriapathwin");
                new File(path+System.getProperty("file.separator")+idAuditoria).mkdir();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return path+System.getProperty("file.separator")+idAuditoria+System.getProperty("file.separator");
    }
    
    public static void copyFile(String path, String fileName, InputStream in) {
        try {
            // write the inputStream to a FileOutputStream
            System.out.println("Guardando en: "+path);
            OutputStream out = new FileOutputStream(new File(path + fileName));
            
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

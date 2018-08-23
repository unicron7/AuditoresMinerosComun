/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author mejiaw
 */
public class FileDownloadController {
    public static File[] listFolder(String ruc, String rutaAdicional) {
        String adjuntoPath="";
        Properties propertiesFile= new Properties();
        if(rutaAdicional==null) {
            try {
            propertiesFile.load(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/sram/config.properties"));
            if(System.getProperty("file.separator").equals("/")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathunix");
                return new File(adjuntoPath+ruc).listFiles();
            } else if(System.getProperty("file.separator").equals("\\")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathwin");
                return new File(adjuntoPath+ruc).listFiles();
            }
            } catch (IOException ex) {
                Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
            propertiesFile.load(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/sram/config.properties"));
            if(System.getProperty("file.separator").equals("/")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathunix");
                return new File(adjuntoPath+ruc+"/"+rutaAdicional).listFiles();
            } else if(System.getProperty("file.separator").equals("\\")) {
                adjuntoPath= propertiesFile.getProperty("adjuntopathwin");
                return new File(adjuntoPath+ruc+"\\"+rutaAdicional).listFiles();
            }
            } catch (IOException ex) {
                Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
   
    public static List<File> obtenerArchivos(String ruc) {
        List<File> filesReturn= new ArrayList<>();
        try {
            File[] fileTmp= FileDownloadController.listFolder(ruc, null);
            for (File fileTmp1 : fileTmp) {
                if(fileTmp1.isFile())
                    filesReturn.add(fileTmp1);
            }
        } catch(Exception ex) {
            System.out.println("Ocurrio un error, no se encontro el archivo: " + ex.toString());
        }
        
        return filesReturn;
    }
    
    public static List<File> obtenerArchivos(String ruc, String rutaAdicional) {
        List<File> filesReturn= new ArrayList<>();
        try {
            File[] fileTmp= FileDownloadController.listFolder(ruc, rutaAdicional);
            for (File fileTmp1 : fileTmp) {
                if(fileTmp1.isFile())
                    filesReturn.add(fileTmp1);
            }
        } catch(Exception ex) {
            System.out.println("Ocurrio un error, no se encontro el archivo: " + ex.toString());
        }
        return filesReturn;
    }
    
    public static List<StreamedContent> obtenerStreamedFiles(String ruc) {
        List<File> filesTmp= FileDownloadController.obtenerArchivos(ruc);
        List<StreamedContent> filesReturn= new ArrayList<>();
        for(File fileTmp1 : filesTmp) {
            InputStream stream= null;
            try {
                stream = new FileInputStream(fileTmp1);
                StreamedContent sc= new DefaultStreamedContent(stream, Files.probeContentType(fileTmp1.toPath()),fileTmp1.getName());
                filesReturn.add(sc);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return filesReturn;
    }
    
    public static List<StreamedContent> obtenerStreamedInformeFiles(String ruc) {
        List<File> filesTmp= FileDownloadController.obtenerArchivos(ruc, "informe");
        List<StreamedContent> filesReturn= new ArrayList<>();
        for(File fileTmp1 : filesTmp) {
            InputStream stream= null;
            try {
                stream = new FileInputStream(fileTmp1);
                StreamedContent sc= new DefaultStreamedContent(stream, Files.probeContentType(fileTmp1.toPath()),fileTmp1.getName());
                filesReturn.add(sc);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return filesReturn;
    }
    
    public static List<StreamedContent> obtenerStreamedCertificadoFiles(String ruc) {
        List<File> filesTmp= FileDownloadController.obtenerArchivos(ruc, "certificado");
        List<StreamedContent> filesReturn= new ArrayList<>();
        for(File fileTmp1 : filesTmp) {
            InputStream stream= null;
            try {
                stream = new FileInputStream(fileTmp1);
                StreamedContent sc= new DefaultStreamedContent(stream, Files.probeContentType(fileTmp1.toPath()),fileTmp1.getName());
                filesReturn.add(sc);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return filesReturn;
    }
    
    public static List<StreamedContent> obtenerStreamedResolucionFiles(String ruc) {
        List<File> filesTmp= FileDownloadController.obtenerArchivos(ruc, "resolucion");
        List<StreamedContent> filesReturn= new ArrayList<>();
        for(File fileTmp1 : filesTmp) {
            InputStream stream= null;
            try {
                stream = new FileInputStream(fileTmp1);
                StreamedContent sc= new DefaultStreamedContent(stream, Files.probeContentType(fileTmp1.toPath()),fileTmp1.getName());
                filesReturn.add(sc);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return filesReturn;
    }
    
    public static StreamedContent obtenerStreamedInfAuditoria(Long idAuditoria) {
        Properties propertiesFile= new Properties();
        String path= "";
        try {
            propertiesFile.load(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/sram/config.properties"));
            if(System.getProperty("file.separator").equals("/")) {
                path= propertiesFile.getProperty("infauditoriapathunix")+idAuditoria;
            } else if(System.getProperty("file.separator").equals("\\")) {
                path= propertiesFile.getProperty("infauditoriapathwin")+idAuditoria;
            }
            File informe= FileDownloadController.obtenerInformeAuditoria(path);
            return new DefaultStreamedContent(new FileInputStream(informe),
                    Files.probeContentType(informe.toPath()),informe.getName());
        } catch (IOException ex) {
            Logger.getLogger(FileDownloadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static File obtenerInformeAuditoria(String path) {
        File[] infs= FileDownloadController.listFolderByPath(path);
        if(infs!=null && infs.length>0) {
            return infs[0];
        }
        return null;
    }
    
    public static File[] listFolderByPath(String path) {
        if(path!=null) {
            return new File(path).listFiles();
        }
        return null;
    }
}

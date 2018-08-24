/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 *
 * @author Will
 */
public class PropertiesReader {
    public static String leer(String property) {
        Properties propertiesFile= new Properties();
        try {
            propertiesFile.load(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/audmin/config.properties"));
            return propertiesFile.getProperty(property);
        } catch (IOException ex) {
            System.out.println("No se logró leer el archivo de propiedades, " + property + " : " + ex.toString());
        }
        return null;
    }
    
    public static String leerUTF8(String property) {
        Properties propertiesFile= new Properties();
        InputStreamReader reader;
        try {
            reader= new InputStreamReader(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/audmin/config.properties"),
                    StandardCharsets.UTF_8);
            propertiesFile.load(reader);
            return propertiesFile.getProperty(property);
        } catch (FileNotFoundException ex) {
            System.out.println("No se logró leer el archivo de propiedades, " + property + " : " + ex.toString());
        } catch (IOException ex) {
            System.out.println("No se logró leer el archivo de propiedades, " + property + " : " + ex.toString());
        }
        return null;
    }
}

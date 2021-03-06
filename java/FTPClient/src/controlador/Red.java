/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JTree;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Recopilacion de los metodos que trabajan mediante FTP.
 * @author Mario Codes Sánchez
 * @since 13/02/2017
 */
public class Red {
    private static final int BUFFER_LENGTH = 8192;
    private static FTPClient ftp;
    private static String conexion;
    private static URL url;
    
    /**
     * Conexion y login mediante FTP al server pasado como parametro con los datos requeridos.
     * @param ip URL del Server.
     * @param puerto Puerto por el cual entra la conexion.
     * @param user Usuario que se conecta.
     * @param pwd Password del Usuario a conectar.
     * @return Estado de la operacion.
     */
    public static boolean login(String ip, int puerto, String user, String pwd) {
        try {
            conexion = "ftp://" +user +": @" +ip +":6598" +"/"; //fixme: los puertos deberian ser dinamicos, no estar hardcodeados. Arreglarlo.
            ftp.connect(ip, puerto);
            return ftp.login(user, pwd);
        }catch(IOException ex) {
            System.out.println("Problema en la conexion o login: " +ex.getLocalizedMessage());
        }
        
        return false;
    }
    
    /**
     * Obtencion de un JTree mapeado pasandole una URL de un server FTP.
     * @param url URL formateada de la siguiente manera: protocolo://user:pwd@ip:puerto".
     * @return JTree formateado para hacer un set directamente.
     */
    public static JTree setArbolFTP(URL url) {
        try {
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            
            JTree tree = new Mapeador().mapearServer(is);
            
            is.close();
            return tree;
        }catch(IOException ex) {
            System.out.println("Problema al hacer set del ArbolFTP: " +ex.getLocalizedMessage());
        }
        
        return null;
    }

    /**
     * Borrado de un elemento en remoto mediante FTP.
     * @param element Elemento a borrar.
     * @return Estado de la operacion.
     */
    public static boolean borrarFTP(String element) {
        try {
            boolean res = false;
            if(element.contains("(Directorio)")) {
                element = element.substring(0, element.indexOf('('));
                res = ftp.removeDirectory(element); //Para quitar [...](Directorio)
                if(res) System.out.println("Directorio remoto Borrado con Exito.");
            } else {
                res = ftp.deleteFile(element);
                if(res) System.out.println("Fichero remoto Borrado con Exito.");
            }
            
            if(!res) System.out.println("Problemas para encontrar o borrar el elemento remoto. Comprueba que no exista.");
            
            return res;
        }catch(IOException ex) {
            System.out.println("Problemas para borrar en remoto: " +ex.getLocalizedMessage());
        }
        
        return false;
    }

    /**
     * Creacion de un directorio con el nombre pasado como parametro.
     * @param name String que sera el nombre del directorio.
     * @return Resultado de la operacion.
     */
    public static boolean mkdirFTP(String name) {
        try {
           boolean res = ftp.makeDirectory(name);

            if(res) System.out.println("¡Directorio remoto Creado con Exito!");
            else System.out.println("Problema para crear el Directorio remoto.");

            return res;
        }catch(IOException ex) {
            System.out.println("Problemas para crear el directorio remoto: " +ex.getLocalizedMessage());
        }
        
        return false;
    }
    
    /**
     * Envio de un fichero desde el Cliente Local al Server FTP.
     * @param rutaLocal Ruta del Cliente donde se buscara el fichero.
     * @param name Nombre con el cual se buscara y creara el fichero.
     * @return Estado de la operacion.
     */
    public static boolean sendFile(String rutaLocal, String name) {
        try {
            url = new URL(conexion +name);
            URLConnection urlConn = url.openConnection();
            OutputStream os = urlConn.getOutputStream();
            FileInputStream fis = new FileInputStream(new File(rutaLocal +name));
            byte[] buffer = new byte[BUFFER_LENGTH];
            
            int count;
            while((count = fis.read(buffer)) >0) {
                os.write(buffer, 0, count);
            }
            os.flush();
            os.close();
            fis.close();
            
            return true;
        }catch(IOException ex) {
            ex.printStackTrace();
            System.out.println("Problema al enviar un fichero al server: " +ex.getLocalizedMessage());
        }
        
        return false;
    }
    
    /**
     * Get de un fichero desde el Server al Cliente Local.
     * @param rutaLocal Ruta en la cual se creara el fichero.
     * @param name Nombre con el cual se busca el fichero en el server y se crea en local.
     * @return Estado de la operacion.
     */
    public static boolean getFile(String rutaLocal, String name) {
        try {
            url = new URL(conexion +name);
            URLConnection urlConn = url.openConnection();
            InputStream is = urlConn.getInputStream();
            FileOutputStream fos = new FileOutputStream(rutaLocal +name);
            byte[] buffer = new byte[BUFFER_LENGTH];
            
            int count;
            while((count = is.read(buffer)) > 0) {
                fos.write(buffer, 0, count);
            }
            fos.flush();
            
            is.close();
            fos.close();
            
            return true;
        }catch(IOException ex) {
            System.out.println("Problema al recibir un fichero desde el Server: " +ex.getLocalizedMessage());
        }
        
        return false;
    }
    
    /**
     * @param aFtp the ftp to set
     */
    public static void setFtp(FTPClient aFtp) {
        ftp = aFtp;
    }
    
    
}

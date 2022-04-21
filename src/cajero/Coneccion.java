
package cajero;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class Coneccion {
    
    public static final String URL = "jdbc:mysql://localhost:3306/banco_2"; //CAMINO QUE VA A CONDUCIR A TU BASE DE DATOS
    public static final String usuario = "root";
    public static final String contraseña = "carp";
    
    public Connection getConnection(){ //METODO QUE ESTABLECE LA CONECCION A LA BASE DE DATOS
        
            Connection coneccion = null;  //LA INICIALIZO CON null PORQUE TODAVIA NOS FALTA UN PASO PARA INICIAR LA CONECCION Y TAMBIEN PORQUE QUIERO QUE SEA ACCESIBLE EN TODO EL AMBITO DEL METODO
            
           
            try{
                
                Class.forName("com.mysql.jdbc.Driver"); //CARGA EL CONECTOR MySQL
                coneccion = (Connection) DriverManager.getConnection(URL,usuario,contraseña); //CONECTA A MI BASE DE DATOS
                
            }catch(Exception e){  //CON EN CATCH ATRAPO LAS DIFERENTES EXCEPCIONES QUE PUEDE ARROJAR LA CONECCION
                
                System.err.println("Error, " + e);
            }
            
            return coneccion;
    }
}

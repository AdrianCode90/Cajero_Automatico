
package cajero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Cajero {

    public static void main(String[] args) {

        final int saldo_inicial = 1000;
        int opcion;
        double ingreso;
        double retiro;
        double saldo_actual = 0;
        String nombre;
        String clave;
        PreparedStatement ps;
        
      
        
        //-----------------------------------------------------------------------------------------------------------------------------

        
          nombre = JOptionPane.showInputDialog("Digite su nombre: ");
          clave = JOptionPane.showInputDialog("Digite su clave: ");
          
          try {
          
             Coneccion con = new Coneccion();
             Connection conexion = con.getConnection();
             
             ps = conexion.prepareStatement("insert into cliente (nombre, clave) values (?,?)");
             ps.setString(1, nombre);
             ps.setString(2, clave);
             
             ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Registro insertado");
             
              
      do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al cajero automatico\n"
                    + "1. Ingresar dinero a la caja de ahorro\n"
                    + "2. Retirar dinero de la caja de ahorro\n"
                    + "3. Salir"));

            switch (opcion) {

                case 1:

                    ingreso = Double.parseDouble(JOptionPane.showInputDialog("Digite el dinero a ingresar: "));
                    saldo_actual += ingreso + saldo_inicial;

                     ps = conexion.prepareStatement("insert into caja_ahorro (saldo) values (?)");
                     ps.setInt(1, (int) saldo_actual);
                     
                     ps.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Dinero en cuenta: " + saldo_actual);

                    break;

                case 2:                           

                    retiro = Double.parseDouble(JOptionPane.showInputDialog("Digite el dinero a retirar: "));

                    if (retiro > saldo_inicial || retiro > saldo_actual) {

                        JOptionPane.showMessageDialog(null, "No cuenta con el saldo suficiente: " + saldo_actual);

                    } else {

                        saldo_actual -= retiro;

                        JOptionPane.showMessageDialog(null, "Dinero en cuenta: " + saldo_actual);
                    }

                    break;

                case 3:

                    JOptionPane.showMessageDialog(null, "Salio del menu");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Se equivoco de numero de opcion de menu");
                    break;
            }

        } while (opcion != 3);
  
          
          }catch (Exception e) {
            
            System.err.println("Error, " + e);
        }
    
    }

}

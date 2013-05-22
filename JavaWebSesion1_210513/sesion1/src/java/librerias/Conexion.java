package librerias;
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    public Connection con;
    public Statement sen; //manejar diversos comandos sql
    public ResultSet res;
    public ResultSetMetaData meta; //estructura de un conjunto de datos, tipo de datos, cantidad de datos,etc.
    public String driver="oracle.jdbc.driver.OracleDriver";
    public String cadena="jdbc:oracle:thin:@localhost:1521:XE";
    public String usuario="hr";
    public String clave="hr";
    public int campos;
    
    public void conectarBD(){
    
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(cadena,usuario,clave);
            sen=con.createStatement();
            JOptionPane.showMessageDialog(null, "Conexion OK");
        
        }catch(ClassNotFoundException e1){
         JOptionPane.showMessageDialog(null, "Error en el Driver");
        }catch(SQLException e2){
        JOptionPane.showMessageDialog(null, "Error en la conexion");
        }
    }
    
    public ResultSet consulta(){
    
        try{
            res=sen.executeQuery("select * from employees");
            meta=res.getMetaData();
            campos=meta.getColumnCount();
        }catch(SQLException e3){
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return res;
    }
    
    public void cerrar(){
    try{
        res.close();
        sen.close();
        con.close();
    
    }catch(Exception e4){
        JOptionPane.showMessageDialog(null, "Error al finalizar");
    }
    }
}
    
    


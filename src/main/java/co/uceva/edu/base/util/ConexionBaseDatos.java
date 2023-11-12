package co.uceva.edu.base.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static String url = "jdbc:postgresql://chunee.db.elephantsql.com:5432/dnprducs";
    private static String username = "dnprducs";
    private static String password = "uc0vZAemikWqxqIfU2AkXoQGaZri0vmF";

    private ConexionBaseDatos(){

    }
   // public static Connection getConnection() throws SQLException {
     //   try {
       //     Class.forName("org.postgresql.Driver");
        //    System.out.println("conectado--------------------------------------------------------------------------------------------------");
       // } catch (ClassNotFoundException e) {
         //   System.out.println("ERROR CONECTANDO----------------------------------------------------------------------------------------------------");
           // e.printStackTrace();
       /* }
        return DriverManager.getConnection(url, username, password);
    }*/
    public static  Connection getConnection() {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("CONECTADO--------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}


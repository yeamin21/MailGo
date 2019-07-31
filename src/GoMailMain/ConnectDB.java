package GoMailMain;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yeami
 */
public class ConnectDB {

    public static Connection connect(){
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:sqlite:GoMail.db";
            Connection con = DriverManager.getConnection(url);
            System.out.println("Connected");
            
            return con;
        } catch (SQLException e) {
          
        }
        return null;

    }
}

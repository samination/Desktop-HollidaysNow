/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.projet.Techniques;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author samination
 */
public class MyConnection {
    public String url="jdbc:mysql://localhost:3306/dbh";
    public String login="root";
    public String pwd="";
    Connection cnx;
    public static MyConnection instance;
    
    private MyConnection(){
        try {
            cnx=DriverManager.getConnection(url,login,pwd);
            System.out.println("Connexion Etablie !");
        } catch (SQLException ex){
            
            System.err.println(ex.getMessage());
        } 
    }
    
    public static MyConnection getInstance(){
        if(instance==null){
            instance=new MyConnection();
        }
        return instance;
    }

    public Connection getConnection(){
        return cnx;
    }
}

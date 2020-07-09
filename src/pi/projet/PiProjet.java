/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.projet;

import java.sql.Connection;
import javafx.application.Application;

import javafx.stage.Stage;
import pi.projet.Entities.Transport;
import pi.projet.Techniques.MyConnection;

/**
 *
 * @author samination
 */
public class PiProjet extends Application {
    
    
        Connection cnx=MyConnection.getInstance().getConnection();
      
    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
       
    
}

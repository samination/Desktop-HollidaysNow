/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.projet.Controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pi.projet.Services.Reserver;


/**
 * FXML Controller class
 *
 * @author samination
 */
public class Annuler_ResrvationController implements Initializable {
    @FXML
    private TextField a1;
    @FXML
    private Button ba1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ba1.setOnAction((ActionEvent event) -> {
     
     String loggin=a1.getText();
        
        if ((loggin.length()!=8)){
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("Verifiez vos paramètres");
                a.show();
        }
            int id=Integer.parseInt(a1.getText());
            Reserver ps2=new Reserver();
     try {
         ps2.supprimeragence(id);
     } catch (SQLException ex) {
         Logger.getLogger(SupArticleController.class.getName()).log(Level.SEVERE, null, ex);
     }
            
            System.out.println("annulé");      
        // TODO
    });    
    
}}

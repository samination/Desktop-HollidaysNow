/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.projet.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pi.projet.Services.CRUDClass;


/**
 * FXML Controller class
 *
 * @author samination
 */
public class AcceuilAnnonceController implements Initializable {
    @FXML
    private Button Acbutton1;
    @FXML
    private Button Acbutton2;
    @FXML
    private Button Acbutton3;
    @FXML
    private Button Acbutton4;
    @FXML
    private Button Acbutton11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       Acbutton1.setOnAction((ActionEvent event) -> { 
      
        
    
    Stage primaryStage=new Stage();
       Parent root=new Parent() {
} ;
           try {
               root = FXMLLoader.load(getClass().getResource("dfdm.fxml"));
           } catch (IOException ex) {
               Logger.getLogger(AcceuilAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
           }
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ajouter un Article");
        primaryStage.setScene(scene);
        primaryStage.show();
    

        
});
     Acbutton2.setOnAction((ActionEvent event) -> { 
      
        
    
    Stage primaryStage=new Stage();
       Parent root=new Parent() {
} ;
           try {
               root = FXMLLoader.load(getClass().getResource("Modifier Article.fxml"));
           } catch (IOException ex) {
               Logger.getLogger(AcceuilAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
           }
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ajouter un Article");
        primaryStage.setScene(scene);
        primaryStage.show();
    

        
});
    
      Acbutton3.setOnAction((ActionEvent event) -> { 
      
        
    
    Stage primaryStage=new Stage();
       Parent root=new Parent() {
} ;
           try {
               root = FXMLLoader.load(getClass().getResource("SupArticle.fxml"));
           } catch (IOException ex) {
               Logger.getLogger(AcceuilAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
           }
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ajouter un Article");
        primaryStage.setScene(scene);
        primaryStage.show();
    

        
});
      
       Acbutton4.setOnAction((ActionEvent event) -> { 
      
        
    
    Stage primaryStage=new Stage();
       Parent root=new Parent() {
} ;
           try {
               root = FXMLLoader.load(getClass().getResource("AfficherAnnonce_1.fxml"));
           } catch (IOException ex) {
               Logger.getLogger(AcceuilAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
           }
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ajouter un Article");
        primaryStage.setScene(scene);
        primaryStage.show();
    

        
});
       Acbutton11.setOnAction((ActionEvent event) -> { 
      
        
    
    Stage primaryStage=new Stage();
       Parent root=new Parent() {
} ;
           try {
               root = FXMLLoader.load(getClass().getResource("AfficherAnnonce11.fxml"));
           } catch (IOException ex) {
               Logger.getLogger(AcceuilAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
           }
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ajouter un Article");
        primaryStage.setScene(scene);
        primaryStage.show();
    

        
});
      
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }




}

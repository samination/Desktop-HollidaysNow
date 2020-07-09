/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.projet.Controllers;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pi.projet.Entities.Transport;
import pi.projet.Entities.Treservation;
import pi.projet.Services.Reserver;

/**
 * FXML Controller class
 *
 * @author samination
 */
public class ReserverController implements Initializable {
    String data_error="";
    @FXML
    private TextField r5;
    @FXML
    private TextField r4;
    @FXML
    private TextField r3;
    @FXML
    private TextField r2;
    @FXML
    private TextField r1;
    @FXML
    private Button br1;
    @FXML
    private TextField r51;
    public void setVoyageOrganise(Transport h){
     
     int t=0;
                
        Transport he = h;          
                
    
      this.r5.setText(String.valueOf(he.getIdAnnonce()));
      
      
      this.r51.setText(String.valueOf(he.getIdAgence()));
      
      
}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        br1.setOnAction((ActionEvent event) -> { 
            String loggin=r5.getText();
        String pass=r2.getText();
        if ((loggin.length()!=8)||(pass=="nn")){
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("Verifiez vos paramètres");
                a.show();
        }
            
            
            
           
            
            /*Notifications notification11 = Notifications.create()
                    .title("felicitation")
                    .text("ajout termineé avec succée")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);*/
        // TODO
        else if(  
                  r2.getText().isEmpty() || 
                  r3.getText().isEmpty() || 
                  r4.getText().isEmpty() ||
                  r5.getText().isEmpty()  
                   )
         {
               
              data_error="Un/Ou plusiers champs sont vides!";
               
            Alert alrt = new Alert(Alert.AlertType.ERROR);
            alrt.setTitle("Alert");
            alrt.setHeaderText("Input Error");
            alrt.setContentText(data_error);
            alrt.showAndWait();
         }
        else{ Treservation p =new Treservation(Integer.parseInt(r2.getText()),Date.valueOf(r3.getText()),Integer.parseInt(r4.getText()),Integer.parseInt(r5.getText()));
            Reserver ps=new Reserver();
            ps.Reserver(p);}
        });
       /* vider_ajout.setOnAction((ActionEvent event) -> {
            
        entry1.setText("");
        entry2.setText("");
        entry3.setText("");
        entry4.setText("");
        entry5.setText("");
        entry6.setText("")
        
        
         });}*/
        
        
        // TODO
    }    
    
}

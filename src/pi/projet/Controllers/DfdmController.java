/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.projet.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static jdk.nashorn.internal.objects.ArrayBufferView.length;
import pi.projet.Entities.Transport;
import pi.projet.Services.CRUDClass;
/*import org.controlsfx.control.Notifications;*/

/**
 * FXML Controller class
 *
 * @author samination
 */
public class DfdmController implements Initializable {
    String data_error="";
    @FXML
    private TextField entry1;
    @FXML
    private TextField entry2;
    @FXML
    private TextField entry3;
    @FXML
    private TextField entry4;
    @FXML
    private TextField entry5;
    @FXML
    private TextField entry6;
    @FXML
    private Button button1;
    @FXML
    private Button vider_ajout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        button1.setOnAction((ActionEvent event) -> { 
            String loggin=entry1.getText();
        String pass=entry2.getText();
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
        else if( entry1.getText().isEmpty() || 
                  entry2.getText().isEmpty() || 
                  entry6.getText().isEmpty() || 
                  entry4.getText().isEmpty() ||
                  entry5.getText().isEmpty()  
                   )
         {
               
              data_error="Un/Ou plusiers champs sont vides!";
               
            Alert alrt = new Alert(Alert.AlertType.ERROR);
            alrt.setTitle("Alert");
            alrt.setHeaderText("Input Error");
            alrt.setContentText(data_error);
            alrt.showAndWait();
         }
        else{ Transport p =new Transport(Integer.parseInt(entry1.getText()), entry2.getText(),Date.valueOf(entry3.getText()),entry4.getText(),Float.parseFloat(entry5.getText()),entry6.getText());
            CRUDClass ps=new CRUDClass();
            ps.ajouterPersonne(p);}
        });
        vider_ajout.setOnAction((ActionEvent event) -> {
            
        entry1.setText("");
        entry2.setText("");
        entry3.setText("");
        entry4.setText("");
        entry5.setText("");
        entry6.setText("");
        
        
         });}
}


    


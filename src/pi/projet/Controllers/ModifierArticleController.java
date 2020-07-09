/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.projet.Controllers;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pi.projet.Entities.Transport;
import pi.projet.Services.CRUDClass;

/**
 * FXML Controller class
 *
 * @author samination
 */
public class ModifierArticleController implements Initializable {
    @FXML
    private TextField entry2_1;
    @FXML
    private TextField entry2_2;
    @FXML
    private TextField entry2_6;
    @FXML
    private TextField entry2_5;
    @FXML
    private TextField entry2_4;
    @FXML
    private TextField entry2_3;
    @FXML
    private Button button2;
    public void setVoyageOrganise(Transport h){
     
     int t=0;
                
      he=h;          
                
    
      this.entry2_1.setText(String.valueOf(he.getIdAnnonce()));
      
      this.entry2_2.setText(he.getNomPos());
      this.entry2_3.setText(String.valueOf(he.getDate_ajout()));
      this.entry2_4.setText(String.valueOf(he.getDescription()));
      this.entry2_5.setText(String.valueOf(he.getPrix()));
      this.entry2_6.setText(he.getEtat());
      
}
    public static Transport he;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              CRUDClass sh=new CRUDClass();
        Transport h=new Transport();
        h.setIdAnnonce(Integer.parseInt(entry2_1.getText()));

        h.setNomPos(entry2_2.getText());
        h.setDate_ajout(Date.valueOf(entry2_3.getText()));
        h.setDescription(entry2_4.getText());
        h.setPrix(Float.parseFloat(entry2_5.getText()));
        h.setEtat(entry2_6.getText());
        
        
       
           if  (entry2_1.getText().length() != 0&&entry2_2.getText().length() != 0&&entry2_3.getText().length() != 0&&entry2_4.getText().length() != 0&&entry2_5.getText().length() != 0&&entry2_6.getText().length() != 0) {
               sh.modifierPersonne(h);
               ((Node)event.getSource()).getScene().getWindow().hide();
           }
           else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("fill all the fields");
            alert.show();
        }
      
            }
        });

    /**
     * Initializes the controller class.
     */
   
    
}}

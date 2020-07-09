/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.projet.Controllers;

import com.sun.jmx.snmp.BerDecoder;
import java.awt.Window;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static pi.projet.Controllers.AfficherAnnonceController.he;
import pi.projet.Entities.Transport;
import pi.projet.Entities.Treservation;
import pi.projet.Services.CRUDClass;
import pi.projet.Services.Reserver;

/**
 * FXML Controller class
 *
 * @author samination
 */
public class Afficher_ReservationController implements Initializable {
        private Reserver ca=new Reserver();

    @FXML
    private ComboBox<String> cm1;
    @FXML
    private TableView<Treservation> ta1;
    @FXML
    private TableColumn<Treservation, Integer> ac1;
    @FXML
    private TableColumn<Treservation, Integer> ac2;
    @FXML
    private TableColumn<Treservation, Date> ac3;
    @FXML
    private TableColumn<Treservation, Integer> ac4;
    @FXML
    private TableColumn<Treservation, Integer> ac5;
        List<Treservation> liste_commentaire;

    ObservableList<String> liste_spec=FXCollections.observableArrayList("nombre de personnes","id de l annonce");
    @FXML
    private TextField ec1;
    @FXML
    private Button br1;
    @FXML
    private Button br2;
    @FXML
    private Button br3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        cm1.setValue("Critère");
        cm1.setItems(liste_spec);
        
        br1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
       if (cm1.getValue()=="id de l annonce") {
             
            
          // ObservableList<Treservation> data=FXCollections.observableArrayList();
     
       List<Treservation> listeCompagnie=ca.afficherTransport(Integer.parseInt(ec1.getText()));
       
       ObservableList obs;
       obs=FXCollections.observableArrayList(listeCompagnie);
       ta1.setItems(obs);
              ac1.setCellValueFactory(new PropertyValueFactory<>("idReservation"));

       ac2.setCellValueFactory(new PropertyValueFactory<>("nbr_personnes"));
              ac3.setCellValueFactory(new PropertyValueFactory<>("date_res"));
       ac4.setCellValueFactory(new PropertyValueFactory<>("id_client"));
       ac5.setCellValueFactory(new PropertyValueFactory<>("id_annonce"));

       /*for(int i=0;i<listeCompagnie.size();i++){
           Treservation c =listeCompagnie.get(i);           
       data.add(c);
           /* ObservableList<Treservation> list;
            Reserver p= new Reserver();
            int r=Integer.parseInt(ec1.getText());
            list=p.displayAllOnIdVol(r);
            ObservableList<Treservation> data=FXCollections.observableArrayList(list);
            ta1.setItems(data);*/
            
       }
       /* ac1.setCellValueFactory(
                new PropertyValueFactory<>("idReservationT"));
       ac2.setCellValueFactory(
                new PropertyValueFactory<>("nombre_de_personnesT"));
       ac3.setCellValueFactory(
                new PropertyValueFactory<>("date_resT"));
       ac4.setCellValueFactory(
                new PropertyValueFactory<>("id_clientT"));
       ac5.setCellValueFactory(
                new PropertyValueFactory<>("idAnnonceT"));
       
        
      
   ta1.setItems(data);*/
             
             
             
         }
         
         

            
          
            
         });
        
        
     
        
        
         br2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (ta1.getSelectionModel().getSelectedItem() != null) {
            try {
                int id = ta1.getSelectionModel().getSelectedItem().getIdReservation();
                Reserver s = new Reserver();
                s.supprimeragence(id);
            } catch (SQLException ex) {
                Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*rafrechir();*/
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner une Reservation ");
            alert.show();
        }
            }
         });
         
         br3.setOnAction(new EventHandler<ActionEvent>() {
        @Override
            public void handle(ActionEvent event) {
                ObservableList<Treservation> data=FXCollections.observableArrayList();
     
       List<Treservation> listeCompagnie=ca.afficherReservation();
       
       for(int i=0;i<listeCompagnie.size();i++){
           Treservation c =listeCompagnie.get(i);           
       data.add(c);
       }

        ac1.setCellValueFactory(
                new PropertyValueFactory<>("idAnnonce"));
       ac2.setCellValueFactory(
                new PropertyValueFactory<>("nomPos"));
       ac3.setCellValueFactory(
                new PropertyValueFactory<>("date_ajout"));
       ac4.setCellValueFactory(
                new PropertyValueFactory<>("description"));
       ac5.setCellValueFactory(
                new PropertyValueFactory<>("Prix"));
       
      
   ta1.setItems(data);
            
                
                
                
                
                
                
                
                
                
                
                
            }
        
            
            
            
         });
        
        
        
        
    }    
    
}



